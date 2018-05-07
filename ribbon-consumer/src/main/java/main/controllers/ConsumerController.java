package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
public class ConsumerController {

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
	public String helloController() {
		String serviceStr = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

		return "Ribbon consumer at port:"+ serverPort + " gets info from hello-service: " + serviceStr;
	}
}