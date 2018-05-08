package main;

import main.fiters.PermisFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by kongxiangwen on 5/8/18 w:19.
 */

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

	@Bean
	PermisFilter permisFilter() {
		return new PermisFilter();
	}
	public static void main(String[] args) {

		SpringApplication.run(ApiGatewayApplication.class, args);
	}
}
