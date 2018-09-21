package com.dcits.spring.cloud.gateway.ratelimiter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class RateLimiterKeyResolver implements KeyResolver {

  private static final String RATE_LIMIT_VALUE = "123";

  @Override
  public Mono<String> resolve(ServerWebExchange exchange) {
    return Mono.just(RATE_LIMIT_VALUE);
  }
}
