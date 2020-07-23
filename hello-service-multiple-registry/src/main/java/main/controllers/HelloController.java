package main.controllers;



import java.util.List;
import main.services.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient client;

	@Value("${server.port}")
	private String serverPort;

	private static Logger log = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private DiscoveryClient discoveryClient;


	@Autowired
	HelloService helloService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@Cacheable
	public String index() {

		//List<ServiceInstance> instances = client.getInstances("hello-service");
		//for (int i = 0; i < instances.size(); i++) {
			//logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
		//}
		log.info("being called");
		return "Hello World from port:"+serverPort;
	}

	@RequestMapping(value = "/geturl", method = RequestMethod.GET)
	public String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("hello-service");
		if (list != null && list.size() > 0 ) {
			return "hello-service:" + list.get(0).getUri().toString();
		}
		List<ServiceInstance> list2 = discoveryClient.getInstances("HELLO-SERVICE");
		if (list2 != null && list2.size() > 0 ) {
			return "HELLO-SERVICE:" + list2.get(0).getUri().toString();
		}
		return "no";
	}


	@RequestMapping("/feign-hello")
	public String hello() {

		return "feign from "
				+helloService.hello();
	}

}
