package services;

import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * Created by kongxiangwen on 5/15/18 w:20.
 */
@Service
@Component
public class DemoServiceImpl implements DemoService {

	private ApplicationContext ctx;
	private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

	public String sayHello(String name) {
		logger.info("sayHello : " + name);

		System.out.println("producer finished");

		return "hello from dubbo provider " + name;
	}

}
