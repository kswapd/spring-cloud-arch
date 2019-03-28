package com.dcits.spring.cloud.gateway.demo;

import com.dcits.spring.cloud.gateway.ratelimiter.RateLimiterKeyResolver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.factory.HystrixGatewayFilterFactory.Config;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
//@SpringBootApplication//(scanBasePackages = "com.dcits.spring.cloud.gateway.endpoint")
//@SpringBootConfiguration
//@EnableAutoConfiguration
@SpringBootApplication
@RestController
public class GatewayApplication {


  @RequestMapping("/fallback")
  public String fallback() {
    return "fallback";
  }


    @RequestMapping("/ok")
    public String ok() {
        return "200 ok";
    }


    @Bean
    RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 1);

    }

    @Bean
    public RateLimiterKeyResolver appkeyResolver(){
        return new RateLimiterKeyResolver();
    }

  @Bean
  public RouteLocator myRoutes(RouteLocatorBuilder builder) {
    BeforeRoutePredicateFactory.Config config = new BeforeRoutePredicateFactory.Config();
    Calendar calendar = Calendar.getInstance(); // gets a calendar using the default time zone and locale.
    calendar.add(Calendar.SECOND, 15);


    String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat(pattern);

    String date = simpleDateFormat.format(calendar.getTime());
    System.out.println(date);

    config.setDatetime(date);
    System.out.println("-------:"+date);

   // configConsumer.



    return builder.routes()


           /* .route(p -> p
                    .path("/get")
                    .filters(f -> f.addRequestHeader("Hello", "World"))

                    .uri("http://httpbin.org:80"))*/

            .route(p -> p
                    .path("/getok")
                    .filters(f -> {
                      f.addRequestHeader("Hello", "OK world");
                      f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/fallback"));
                        f.rewritePath("/getok","/get");

                      return f;

                    })
                    .uri("http://httpbin.org:80"))

            .route(p -> p
                    .path("/getlocalok")
                    .filters(f -> {
                        f.addRequestHeader("Hello", "OK world");
                        f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/fallback"));
                        f.rewritePath("/getlocalok","/ok");

                        return f;

                    })
                    .uri("lb://spring-gateway-demo"))

            .route(p -> p
                    .path("/getlimit")
                    .filters(f -> {
                        f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter()).setKeyResolver(appkeyResolver()));
                        f.rewritePath("/getlimit","/ok");

                        return f;

                    })
                    //.uri("http://httpbin.org"))
                    .uri("lb://spring-gateway-demo"))

            .route(p -> p
                    .path("/getlimitfb")
                    .filters(f -> {
                        f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter()).setKeyResolver(appkeyResolver()));
                        f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/fallback"));
                        f.rewritePath("/getlimitfb","/ok");
                        return f;
                    })
                    //.uri("http://httpbin.org"))
                    .uri("lb://spring-gateway-demo"))

            .route(p -> p
                    .path("/gethys")
                    .filters(f -> {

                        f.addResponseHeader("Hello", "Hystrix");
                        f.hystrix(c -> c.setName("ppp").setFallbackUri("forward:/fallback"));
                        f.rewritePath("/gethys","/get-no");

                        return f;

                    })
                    .uri("http://httpbin.org:80"))
            .route(p -> p
                    .path("/oms/uaa/**")

                    .filters(f -> {
                      /*f.removeResponseHeader("x-frame-options");
                    f.removeResponseHeader("www-authenticate");
                    f.removeResponseHeader("x-content-type-options");
                    f.removeResponseHeader("x-xss-protection");
                    f.removeResponseHeader("cache-control");
                    f.addRequestHeader("Authorization", "Basic b21zLXdlYjpvbXMtd2Vi");*/
                      f.rewritePath("/oms/uaa/(?<segment>.*)","/${segment}");
                    return f;
                    })
                    .uri("lb://auth-service")
                    //.uri("http://10.88.2.108:8085")
                    .predicate(new BeforeRoutePredicateFactory().apply(config))

            )

            .route(p -> p
                    .path("/uaa")
                    .filters(f -> f.addRequestHeader("Hello", "World"))
                    .uri("lb://auth-service"))
            .build();
  }

  public static void main(String[] args) {

    SpringApplication.run(GatewayApplication.class, args);


  }
  /*
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
            .route("path_route", r -> r.path("/get")
                    .uri("http://httpbin.org"))
            .route("host_route", r -> r.host("*.myhost.org")
                    .uri("http://httpbin.org"))
            .route("rewrite_route", r -> r.host("*.rewrite.org")
                    .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
                    .uri("http://httpbin.org"))
            .route("hystrix_route", r -> r.host("*.hystrix.org")
                    .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
                    .uri("http://httpbin.org"))
            .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
                    .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
                    .uri("http://httpbin.org"))
            *//*.route("limit_route", r -> r
                    .host("*.limited.org").and().path("/anything/**")
                    .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
                    .uri("http://httpbin.org"))*//*
            .build();
  }
*/

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
