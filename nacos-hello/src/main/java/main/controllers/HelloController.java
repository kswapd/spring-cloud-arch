package main.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
//@RequestMapping(value = "/aa")
//@RequestMapping("/")
@RefreshScope
public class HelloController {
	//private final Logger logger = Logger.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;

	@Value("${server.port}")
	private String serverPort;

	private static Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String index() {
		log.info("being called");
		return "Hello World from port:"+serverPort;
	}

}
