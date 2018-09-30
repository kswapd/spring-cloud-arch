package com.dcits.spring.cloud.gateway.demo;

import com.dcits.spring.cloud.gateway.ratelimiter.InMemoryRateLimiter;
import com.dcits.spring.cloud.gateway.ratelimiter.RateLimiterKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

//@Configuration
//@SpringBootApplication//(scanBasePackages = "com.dcits.spring.cloud.gateway.endpoint")
@SpringBootConfiguration
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

  public static void main(String[] args) {

    SpringApplication.run(GatewayApplication.class, args);
  }


 /* @Bean
  public RateLimiter inMemoryRateLimiter() {
    return new InMemoryRateLimiter();
  }

  @Bean
  public KeyResolver rateLimiterKeyResolver() {
    return new RateLimiterKeyResolver();
  }
*/

}
