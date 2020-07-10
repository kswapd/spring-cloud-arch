package com.dcits.controllers;



import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
//@RequestMapping(value = "/aa")
public class HelloController {
	//private final Logger logger = Logger.getLogger(HelloController.class);
	@Autowired
	private RestTemplate restTemplate;

	/*@Resource(name="myKafka")
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
		log.info("kafka template msg:{}",kafkaTemplate.toString());
		kafkaTemplate.send("testbb", "hi", msg);
		log.info("kafka send finish");
	}*/
	private int i = 0;
	@Value("${server.port}")
	private String serverPort;

	private static Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@Cacheable
	public String index() {

		//List<ServiceInstance> instances = client.getInstances("hello-service");
		//for (int i = 0; i < instances.size(); i++) {
			//logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
		//}
		log.info("being called");
		String test = restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
		String snd = "kafka hi " + i;
		//sendMessage(snd);
		i ++;
		log.info("being called finish:{}", test);
		return "Hello Kafka from port:"+serverPort+":"+test;
	}

}
