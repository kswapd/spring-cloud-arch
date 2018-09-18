package main.controllers;

import main.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/8/18 w:19.
 */

@RestController
public class FeignConsumerController {
	@Autowired
	HelloService helloService;
	@RequestMapping("/feign-consumer")
	public String hello() {
		return "feign from "+helloService.hello();
	}




}
