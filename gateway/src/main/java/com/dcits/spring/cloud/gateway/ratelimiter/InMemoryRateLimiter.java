package com.dcits.spring.cloud.gateway.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.ratelimit.AbstractRateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

//@ConfigurationProperties("spring.cloud.gateway.rate-limiter")
public class InMemoryRateLimiter extends AbstractRateLimiter<InMemoryRateLimiter.Config> {

  private static final String CONFIGURATION_PROPERTY_NAME = "rate-limiter";

  private final Config defaultConfig = new Config().setBurstCapacity(10);

  private final Map<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

  public InMemoryRateLimiter() {
    super(Config.class, CONFIGURATION_PROPERTY_NAME, null);
  }


  @Override
  public Mono<Response> isAllowed(String routeId, String id) {
    Config config = getConfig().getOrDefault(routeId, defaultConfig);
    Assert.notNull(config, this.getClass().getSimpleName() + " Config is null.");
    RateLimiter rateLimiter = rateLimiterMap.computeIfAbsent(id, id1 -> RateLimiter.create(config.getBurstCapacity()));
    return Mono.just(new Response(rateLimiter.tryAcquire(), getHeaders(config, rateLimiter.acquire())));
  }

  @NotNull
  private HashMap<String, String> getHeaders(Config config, double tokensLeft) {
    HashMap<String, String> headers = new HashMap<>();
    headers.put(RedisRateLimiter.REMAINING_HEADER, "" + Double.valueOf(tokensLeft).intValue());
    headers.put(RedisRateLimiter.BURST_CAPACITY_HEADER, String.valueOf(config.getBurstCapacity()));
    return headers;
  }

  @Validated
  public static class Config {

    @Min(1)
    private int burstCapacity = 1;

    public int getBurstCapacity() {
      return burstCapacity;
    }

    public Config setBurstCapacity(int burstCapacity) {
      this.burstCapacity = burstCapacity;
      return this;
    }

    @Override
    public String toString() {
      return "Config{" +
          "burstCapacity=" + burstCapacity +
          '}';
    }
  }
}
