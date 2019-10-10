package main.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import main.beans.ApolloBean;
import main.services.HelloService;
import main.services.LocalCheck;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
public class HelloController {
	//private final Logger logger = Logger.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;


	private static Logger log = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private String serverPort;


	@Autowired
	private HelloService hs;


	@Autowired
	private ApolloBean ab;
	//@Autowired
	//private RabbitTemplate template;

	@Autowired
	private LocalCheck localCheck;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping(){
		return "pong";
	}

	@RequestMapping(value = "/apollo", method = RequestMethod.GET)
	public String apollo(){

		return ab.getInfo();
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
