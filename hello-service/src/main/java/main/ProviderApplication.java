package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */



@SpringBootApplication
public class ProviderApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProviderApplication.class, args);
	}

	/*@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}*/

}
