package main.beans;


import main.models.MyEventListener;
import org.springframework.cloud.cluster.leader.event.LoggingListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public LoggingListener loggingListener() {
    return new LoggingListener("info");
  }


    @Bean
    public MyEventListener myEventListener() {
      return new MyEventListener();
    }

}