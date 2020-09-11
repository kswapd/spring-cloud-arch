package com.dcits.spring.cloud.gateway.endpoint;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

public class RouteProfile {

  private String id = UUID.randomUUID().toString();

  private List<PredicateDefinition> predicates = new ArrayList<>();

  private List<FilterDefinition> filters = new ArrayList<>();

  private URI uri;

  private int order = 0;

  public RouteProfile() {
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<PredicateDefinition> getPredicates() {
    return predicates;
  }

  public void setPredicates(List<PredicateDefinition> predicates) {
    this.predicates = predicates;
  }

  public List<FilterDefinition> getFilters() {
    return filters;
  }

  public void setFilters(List<FilterDefinition> filters) {
    this.filters = filters;
  }

  public URI getUri() {
    return uri;
  }

  public void setUri(URI uri) {
    this.uri = uri;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }
}