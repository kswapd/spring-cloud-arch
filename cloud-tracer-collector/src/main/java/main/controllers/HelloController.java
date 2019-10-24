package main.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import main.services.HelloService;
import main.services.LocalCheck;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
public class HelloController {
	// private final Logger logger = Logger.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;

	private static Logger log = LoggerFactory.getLogger(HelloController.class);
	private String test = null;
	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private HelloService hs;

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private LocalCheck localCheck;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(value = "/cacheable", method = RequestMethod.GET)
	@Cacheable
	public String cacheable() {
		return "cacheable";
	}

	@RequestMapping(value = "/cacheput", method = RequestMethod.GET)
	@CachePut
	public String cacheput() {
		return "cacheput";
	}

	@RequestMapping(value = "/cacheevict", method = RequestMethod.GET)
	@CacheEvict
	public String cacheevict() {
		return "cacheevict";
	}

	@RequestMapping(value = "/zipkin-call", method = RequestMethod.GET)
	public String call() {
		String msgProvider = "before";
		// localSysCheck.accountCheck();
		// localSysCheck.localEnvCheck();
		localCheck.localSysCheck();
		
		// Thread thread = new Thread((new Runnable() {

		// 	@Override
		// 	public void run() {
		// 		System.out.println(Thread.currentThread().hashCode());
		// 		test = restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);

		// 	}
		// }));

		// thread.start();
		// try {
		// 	thread.join();
		// } catch (InterruptedException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		// }

		test = restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);

		//String msgProvider = restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
		//String msgApiGateway = restTemplate.getForObject("http://API-GATEWAY/hello-service/hello?login=a", String.class);
		log.info("calling");
		localCheck.localSysCheck();
		//localCheck.localEnvCheck();
		//template.convertAndSend("exchangeTracing","hello","Hello,hello!");

		return "zipkin get msg:"+test;
		//return "zipkin get msg:"+msgProvider+" API gateway msg:" + msgApiGateway;

	}

	@RequestMapping(value = "/mq-call", method = RequestMethod.GET)
	public String mqcall() {

		log.info("calling");

		template.convertAndSend("exchangeTracing","hello","Hello,rabbitmq!");
		return "zipkin send msg:rabbitmq";
		//return "zipkin get msg:"+msgProvider+" API gateway msg:" + msgApiGateway;

	}



	@RequestMapping(value = "/open-acct", method = RequestMethod.GET)
	public String anncall() {

		localCheck.localSysCheck();
		localCheck.localEnvCheck();

		String msgProvider = hs.hello();
		//String msgApiGateway = restTemplate.getForObject("http://API-GATEWAY/hello-service/hello?login=a", String.class);
		log.info("calling ann");

		return "zipkin get annotation msg:"+msgProvider;
		//return "zipkin get msg:"+msgProvider+" API gateway msg:" + msgApiGateway;

	}



}
