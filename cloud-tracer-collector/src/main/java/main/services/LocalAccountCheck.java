package main.services;


import com.dcits.cloud.traces.annotations.InvokingChainMonitor;
import com.dcits.cloud.traces.annotations.InvokingChainTags;
import main.utils.RandomSleep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LocalAccountCheck {

	private static Logger log = LoggerFactory.getLogger(LocalAccountCheck.class);

	@InvokingChainMonitor(tags={@InvokingChainTags(key="key1", value = "val1"),
					@InvokingChainTags(key="key2", value="val2")})
	public void accountCheck()
	{
		RandomSleep.Sleep();
		PrivateSecond();
		log.info("finished");
	}

	@InvokingChainMonitor
	public void PrivateSecond()
	{
		RandomSleep.Sleep();
	}
}
