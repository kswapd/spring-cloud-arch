package com.dcits.beans;

import com.dcits.apps.Demo;
import java.util.List;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kongxiangwen on 12/4/18 w:49.
 */
public class ZkGetMasterBean implements IZkChildListener, IZkDataListener, IZkStateListener {
	private final static Logger LOGGER = LoggerFactory.getLogger(Demo.class);

	private String path = "/mylock/bbc";
	private String lockPath = path + "/" + "lock";
	private ZkClient zkClient = null;
	//String locakpath = "/mylock/a/lock";
	//String test = "/mylock/ab/cd/ef/g";
	private boolean isMaster = false;
	public boolean isMaster(){
		return isMaster;
	}
	public ZkGetMasterBean(){


		 zkClient = new ZkClient("127.0.0.1:2181",20000,5000);


		//zkClient.createPersistent(test,"efg");
		//String info = zkClient.readData(locakpath);
		LOGGER.info("zk lock init");
	}
	public boolean TryMaster(){
		boolean ret = false;
		if (zkClient.exists(lockPath))
		{
			LOGGER.info("zk lock failed");
			ret = false;

		}else {
			try {

				zkClient.createPersistent(path, true);
				//zkClient.createPersistent(lockPath, "abcd");
				zkClient.createEphemeral(lockPath, "abcd");
				LOGGER.info("zk lock ok");
				ret = true;
				isMaster = true;
			}
			catch (Exception e) {
				LOGGER.info("zk lock error");
				LOGGER.info(e.toString());
				ret = false;
				isMaster = false;
			}
		}

		if(!isMaster){
			setListener();
		}

		return ret;
		/*try {
			zkClient.createPersistent(path, "abcd");
			zkClient.createEphemeral(path, "abcd");

		} catch (Exception e) {

			return false;
		}

		return true;*/
	}
	public boolean CancelMaster()
	{
		boolean ret = true;
		if(isMaster()) {
			cancelListener();
			if (zkClient.exists(lockPath)) {
				zkClient.delete(lockPath);
				LOGGER.info("delete lockPath");
				while (zkClient.exists(lockPath)) {
					LOGGER.info("delete lockPath inner");
					try {
						Thread.sleep(100);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
						ret = false;
					}
				}
			}

			isMaster = false;
		}
		return ret;
	}



	public void setListener() {
		LOGGER.info("setListener");
		if(zkClient != null) {
			zkClient.subscribeStateChanges(this);
			if (!zkClient.exists(path)) {
				zkClient.createPersistent(path, true);
			}
			if(zkClient.exists(path)) {
				zkClient.subscribeDataChanges(lockPath, this);
			}
			zkClient.subscribeChildChanges(path, this);
		}

	}


	public void cancelListener() {
		LOGGER.info("cancelListener");
		if(zkClient != null) {
			zkClient.unsubscribeStateChanges(this);
			/*if (!zkClient.exists(lockPath)) {
				zkClient.createPersistent(lockPath, true);
			}*/
			zkClient.unsubscribeDataChanges(lockPath, this);
			zkClient.unsubscribeChildChanges(path, this);
		}

	}


	private void onChanged()
	{
		TryMaster();
	}
	@Override
	public void handleChildChange(String path, List<String> tasks) throws Exception {

		LOGGER.info("handleChildChange");
		onChanged();
		//AppReg();
		//dealTasks();
	}

	//有未处理的TASK事件
	@Override
	public void handleDataChange(String s, Object o) throws Exception {
		LOGGER.info("handleDataChange");
		onChanged();
		//dealTasks();
	}

	//有未处理的TASK事件删除（不存在此事件）
	@Override
	public void handleDataDeleted(String s) throws Exception {
		LOGGER.info("handleDataDeleted");
		onChanged();
	}

	@Override
	public void handleStateChanged(KeeperState keeperState) throws Exception {
		LOGGER.info("handleStateChanged");
		onChanged();
	}

	@Override
	public void handleNewSession() throws Exception {
		LOGGER.info("handleNewSession");
		onChanged();
	}
}
