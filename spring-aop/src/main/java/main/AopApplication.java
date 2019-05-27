package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */


//Advice MethodInterceptor 动态 代理
// todo by kxw
//@ImportResource(value = {"classpath:META-INF/spring/*.xml"})
@SpringBootApplication
public class AopApplication {


	static final String topicExchangeName = "exchangeTracing";

	static final String queueName = "spring-boot";


	public static void main(String[] args) {

		System.out.println("AOP started...");
		SpringApplication.run(AopApplication.class, args);
		System.out.println("AOP started...222");


	}
}
