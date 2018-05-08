package main.controllers;




import models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
public class BookController {
	//private final Logger logger = Logger.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;


	@Value("${server.port}")
	private String serverPort;


	@RequestMapping(value = "/getbook", method = RequestMethod.GET)

	public Book index() {

		//List<ServiceInstance> instances = client.getInstances("hello-service");
		//for (int i = 0; i < instances.size(); i++) {
			//logger.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
		//}
		return new Book();
	}
}
