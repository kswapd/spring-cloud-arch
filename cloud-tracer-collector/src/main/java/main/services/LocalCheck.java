package main.services;


import com.dcits.cloud.traces.annotations.InvokingChainMonitor;
import com.dcits.cloud.traces.annotations.InvokingChainTags;
import main.utils.RandomSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalCheck {
	private static Logger log = LoggerFactory.getLogger(LocalCheck.class);
	@Autowired
	private LocalAccountCheck localAccountCheck;

	@Autowired
	private HelloService hs;

	//@InvokingChainMonitor
	public void localSysCheck()
	{
		RandomSleep.Sleep();
		//hs.hello();
		RandomSleep.Sleep();
		log.info("finished");
	}
		//@InvokingChainMonitor
		public void localEnvCheck()
	{
		RandomSleep.Sleep();
		localAccountCheck.accountCheck();
		log.info("finished");
	}
	@InvokingChainMonitor(value = "gravity.node", tags = {@InvokingChainTags(key = "uri", value = "exchange.getUri()"),
    @InvokingChainTags(key = "nodeId", value = "exchange.getNodeDefinition().getId()"), @InvokingChainTags(key = "clazz", value = "exchange.getNodeDefinition().getClassName()"),
	@InvokingChainTags(key = "method", value = "exchange.getNodeDefinition().getMethod()")})
	public void localEnvCheckDetail()
	{
		RandomSleep.Sleep();
		localAccountCheck.accountCheck();
		log.info("finished");
	}
}
