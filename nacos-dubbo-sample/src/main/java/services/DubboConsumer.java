package services;


import org.apache.dubbo.config.annotation.Reference;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
public class DubboConsumer {

	@Reference
	private DemoService demoService;

	public String doSayHell(String name) {
		return demoService.sayHello(name);
	}
}
