package main.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kongxiangwen on 5/8/18 w:19.
 */

@FeignClient(value = "hello-service")
public interface HelloService {
	@RequestMapping("/hello")
	String hello();
}
