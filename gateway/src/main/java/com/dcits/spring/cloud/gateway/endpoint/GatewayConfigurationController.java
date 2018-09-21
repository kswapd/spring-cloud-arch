package com.dcits.spring.cloud.gateway.endpoint;


import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/api/gateway")
public class GatewayConfigurationController implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher applicationEventPublisher;

  private RouteDefinitionLocator routeDefinitionLocator;
  private RouteDefinitionWriter routeDefinitionWriter;
  private RouteLocator routeLocator;

  @SuppressWarnings("all")
  public GatewayConfigurationController(RouteDefinitionLocator routeDefinitionLocator, RouteDefinitionWriter routeDefinitionWriter,
      RouteLocator routeLocator) {
    this.routeDefinitionLocator = routeDefinitionLocator;
    this.routeDefinitionWriter = routeDefinitionWriter;
    this.routeLocator = routeLocator;
  }

  @GetMapping("/routes")
  public Mono<List<Map<String, Object>>> routes() {
    Mono<Map<String, RouteDefinition>> routeDefinitions = this.routeDefinitionLocator.getRouteDefinitions().collectMap(RouteDefinition::getId);
    Mono<List<Route>> routes = this.routeLocator.getRoutes().collectList();

    return Mono.zip(routeDefinitions, routes).map(tuple -> {
      Map<String, RouteDefinition> routeDef = tuple.getT1();
      List<Route> routeList = tuple.getT2();
      List<Map<String, Object>> allRoutes = new ArrayList<>();

      routeList.forEach(route -> {
        HashMap<String, Object> r = new HashMap<>();
        r.put("route_id", route.getId());
        r.put("order", route.getOrder());

        if (routeDef.containsKey(route.getId())) {
          r.put("route_definition", routeDef.get(route.getId()));
        } else {
          HashMap<String, Object> obj = new HashMap<>();

          obj.put("predicate", route.getPredicate().toString());

          if (!route.getFilters().isEmpty()) {
            ArrayList<String> filters = new ArrayList<>();
            for (GatewayFilter filter : route.getFilters()) {
              filters.add(filter.toString());
            }

            obj.put("filters", filters);
          }

          if (!obj.isEmpty()) {
            r.put("route_object", obj);
          }
        }
        allRoutes.add(r);
      });

      return allRoutes;
    });
  }

  @PutMapping("/routes/{id}")
  public Mono<ResponseEntity<Void>> save(@PathVariable String id, @RequestBody Mono<RouteProfile> route) {
    return this.routeDefinitionWriter.save(
        this.routeDefinitionLocator.getRouteDefinitions()
            .filter(routeDefinition -> Objects.equals(routeDefinition.getId(), id))
            .map(definition -> mergeRouteProfileToRouteDefinition(route, definition))
            .single(mergeRouteProfileToRouteDefinition(route, new RouteDefinition())))
        .then(Mono.defer((Supplier<Mono<ResponseEntity<Void>>>) () -> Mono.just(ResponseEntity.created(URI.create("routes/" + id)).build())));
  }


  @PutMapping("/route/{key}")
  public Mono<ResponseEntity<Void>> saveSpecialValue(@PathVariable String key, @RequestBody String value) {
    Map<String, String> params = new HashMap<>();

    if (key.startsWith("spring.cloud.gateway")) {
      key = key.substring("spring.cloud.gateway".length() + 1);
    }
    key = fillParamValues(params, "filters", fillParamValues(params, "predicates", fillParamValues(params, "routes", key)));
    int index = key.indexOf("args");

    if (index != -1) {
      key = key.substring(index + "args".length() + 1);
    }
    String argKey = key;
    String routeName = params.get("routesName");
    String predicatesName = params.get("predicatesName");
    String filtersName = params.get("filtersName");
    boolean hasRoute = StringUtils.hasLength(routeName);
    boolean hasPredicates = StringUtils.hasLength(predicatesName);
    boolean hasFilters = StringUtils.hasLength(filtersName);

    return this.routeDefinitionLocator.getRouteDefinitions().map(definition -> {
      if (hasRoute && !definition.getId().equals(routeName)) {
        return null;
      }
      definition.getPredicates().forEach(pd -> {
        if (hasPredicates && !pd.getName().equals(predicatesName)) {
          return;
        }
        if (pd.getArgs().containsKey(argKey)) {
          pd.getArgs().put(argKey, value);
        }
      });
      definition.getFilters().forEach(fd -> {
        if (hasFilters && !fd.getName().equals(filtersName)) {
          return;
        }
        if (fd.getArgs().containsKey(argKey)) {
          fd.getArgs().put(argKey, value);
        }
      });
      routeDefinitionWriter.save(Mono.just(definition));
      return definition;
    }).then(Mono.just(ResponseEntity.created(URI.create("routes/")).build()));
  }

  private String fillParamValues(Map<String, String> params, String key, String value) {
    int index = value.indexOf(key + "[");

    if (index == -1) {
      return value;
    }
    int endIndex = value.indexOf("]");
    params.put(key + "Name", value.substring(index + (key + "[").length(), endIndex));
    return value.substring(endIndex + 1);
  }

  private RouteDefinition mergeRouteProfileToRouteDefinition(Mono<RouteProfile> route, RouteDefinition definition) {
    return route.filter(routeProfile -> notEquals(routeProfile, definition))
        .flatMap((Function<RouteProfile, Mono<RouteDefinition>>) profile -> Mono.just(definition).map(def -> setOrderIfAbsent(profile, def))
            .map(def -> setUriIfAbsent(profile, def))
            .map(def -> setPredicatesIfAbsent(profile, def))
            .map(def -> setFiltersIfAbsent(profile, def)))
        .defaultIfEmpty(definition).block();
  }

  private RouteDefinition setOrderIfAbsent(RouteProfile profile, RouteDefinition definition) {
    if (profile.getOrder() != 0) {
      definition.setOrder(profile.getOrder());
    }
    return definition;
  }

  private RouteDefinition setUriIfAbsent(RouteProfile profile, RouteDefinition definition) {
    if (profile.getUri() != null && !profile.getUri().equals(definition.getUri())) {
      definition.setUri(profile.getUri());
    }
    return definition;
  }

  private RouteDefinition setPredicatesIfAbsent(RouteProfile profile, RouteDefinition definition) {
    if (CollectionUtils.isEmpty(profile.getPredicates())) {
      return definition;
    }
    profile.getPredicates().stream().filter(pre -> !definition.getPredicates().contains(pre))
        .forEach(pre -> definition.getPredicates().add(pre));
    return definition;
  }

  private RouteDefinition setFiltersIfAbsent(RouteProfile profile, RouteDefinition definition) {
    if (CollectionUtils.isEmpty(profile.getFilters())) {
      return definition;
    }
    profile.getFilters().stream().filter(pre -> !definition.getFilters().contains(pre))
        .forEach(filter -> {
          if (!StringUtils.hasText(filter.getName())) {
            return;
          }
          definition.getFilters()
              .stream().filter(fd -> fd.getName().equals(filter.getName()))
              .forEach(fd -> fd.getArgs().putAll(filter.getArgs()));
        });
    return definition;
  }


  private boolean notEquals(RouteProfile profile, RouteDefinition definition) {
    return profile.getOrder() != 0 && definition.getOrder() != profile.getOrder() ||
        profile.getUri() != null && !profile.getUri().equals(definition.getUri()) ||
        !CollectionUtils.isEmpty(profile.getFilters()) && !definition.getFilters().containsAll(profile.getFilters()) ||
        !CollectionUtils.isEmpty(profile.getPredicates()) && !definition.getPredicates().containsAll(profile.getPredicates());
  }


  @PostMapping("/refresh")
  public Mono<ResponseEntity<Void>> refresh() {
    this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
    return Mono.just(ResponseEntity.ok().build());
  }

  @SuppressWarnings("all")
  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

}
