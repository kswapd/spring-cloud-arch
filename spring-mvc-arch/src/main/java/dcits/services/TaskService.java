package dcits.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by kongxiangwen on 7/6/18 w:27.
 */

@Service
public class TaskService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private DeferredResult<String> myret = null;


	public String runTask() {
		try {
			//myret = null;
			Thread.sleep(10000);
			String output = "Slow task executed:"+Thread.currentThread().getId();
			logger.info(output);
			if(myret != null){
				logger.info("setting myret");
				myret.setResult(output);
			}
			return output;
		}
		catch (InterruptedException e) {
			throw new RuntimeException();
		}
	}

	public void SetDeferredResult(DeferredResult<String> ret){

		myret = ret;
	}
}
