package com.dcits.spring.cloud.gateway.demo;

import com.dcits.spring.cloud.gateway.ratelimiter.InMemoryRateLimiter;
import com.dcits.spring.cloud.gateway.ratelimiter.RateLimiterKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.dcits.spring.cloud.gateway.endpoint")
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }


  @Bean
  public RateLimiter inMemoryRateLimiter() {
    return new InMemoryRateLimiter();
  }

  @Bean
  public KeyResolver rateLimiterKeyResolver() {
    return new RateLimiterKeyResolver();
  }
}
