package main.services;

import org.springframework.stereotype.Component;

/**
 * Created by kongxiangwen on 5/8/18 w:19.
 */
@Component
public class HelloServiceFallback implements  HelloService{
	@Override
	public String hello()
	{
		return "hystrix fallback hello";
	}
}
