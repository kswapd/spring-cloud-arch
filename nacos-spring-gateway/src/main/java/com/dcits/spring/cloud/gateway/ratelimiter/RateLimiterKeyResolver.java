package com.dcits.spring.cloud.gateway.ratelimiter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class RateLimiterKeyResolver implements KeyResolver {

  private static final String RATE_LIMIT_VALUE = "123";
  public static final String BEAN_NAME = "remoteAddrKeyResolver";
  @Override
  public Mono<String> resolve(ServerWebExchange exchange) {
   //return Mono.just(RATE_LIMIT_VALUE);
    System.out.println("-----address:"+exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    return Mono.just(BEAN_NAME+":"+exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());

  }
}
