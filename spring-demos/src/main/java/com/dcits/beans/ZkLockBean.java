package com.dcits.beans;

import com.dcits.apps.Demo;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kongxiangwen on 12/4/18 w:49.
 */
public class ZkLockBean {
	private final static Logger LOGGER = LoggerFactory.getLogger(Demo.class);

	private String path = "/mylock/abcdefghi";
	private String lockPath = path + "/" + "lock";
	private ZkClient zkClient = null;
	//String locakpath = "/mylock/a/lock";
	//String test = "/mylock/ab/cd/ef/g";
	public ZkLockBean(){


		 zkClient = new ZkClient("10.88.2.116:2181",20000,5000);


		//zkClient.createPersistent(test,"efg");
		//String info = zkClient.readData(locakpath);
		LOGGER.info("zk lock init");
	}
	public boolean lock(){
		boolean ret = false;
		if (zkClient.exists(lockPath))
		{
			LOGGER.info("zk lock failed");
			ret = false;
			return ret;
		}else {
			try {

				zkClient.createPersistent(path, true);
				//zkClient.createPersistent(lockPath, "abcd");
				zkClient.createEphemeral(lockPath, "abcd");
				LOGGER.info("zk lock ok");
				ret = true;
			}
			catch (Exception e) {
				LOGGER.info("zk lock error");
				LOGGER.info(e.toString());
				ret = false;
			}
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
	public boolean unlock()
	{
		boolean ret  = true;
		if (zkClient.exists(lockPath))
		{
			zkClient.delete(lockPath);
			LOGGER.info("delete lockPath");
			while (zkClient.exists(lockPath))
			{
				LOGGER.info("delete lockPath inner");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
					ret = false;
				}
			}
		}
		return ret;
	}
}
