package main.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.cluster.leader.event.AbstractLeaderEvent;
import org.springframework.cloud.cluster.leader.event.OnGrantedEvent;
import org.springframework.cloud.cluster.leader.event.OnRevokedEvent;
import org.springframework.context.ApplicationListener;

public class MyEventListener implements ApplicationListener<AbstractLeaderEvent> {
  private static Logger log = LoggerFactory.getLogger(MyEventListener.class);

  @Override
  public void onApplicationEvent(AbstractLeaderEvent event) {
    // do something with OnGrantedEvent or OnRevokedEvent
   // OnGrantedEvent e;
    if(event instanceof OnGrantedEvent){
      log.info("granted.....");

    }else if(event instanceof OnRevokedEvent){
      log.info("revoked.....");
    }
  }
}
