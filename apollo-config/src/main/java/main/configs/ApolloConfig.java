package main.configs;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.beans.ApolloBean;

@Configuration
@EnableApolloConfig
public class ApolloConfig {
  @Bean
  public ApolloBean javaConfigBean() {
    return new ApolloBean();
  }
}