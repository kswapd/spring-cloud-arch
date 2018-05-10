package main.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.util.logging.resources.logging;

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


	@RequestMapping(value = "/zipkin-call", method = RequestMethod.GET)
	public String call() {
		String msgProvider = restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);


		String msgApiGateway = restTemplate.getForObject("http://API-GATEWAY/hello-service/hello?login=a", String.class);

		log.info("calling");
		return "zipkin get msg:"+msgProvider+" API gateway msg:" + msgApiGateway;

	}

}
