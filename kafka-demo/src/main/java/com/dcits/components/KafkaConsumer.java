package com.dcits.components;
import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @PostConstruct
    public void init(){
         System.out.println("init");
    }
  /* @KafkaListener(topics = {"test"}, id="tt")
   public void consumer(ConsumerRecord<?, ?> record)
   {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record {}", record);
        }
            //log.info("------------------ message {}", message);
    }*/


    @KafkaListener(topics = "myzipkin")
    public void receive1(ConsumerRecord<?, ?> consumer) {
        log.info("getZipkinMsg {} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    }

    @KafkaListener(topics = "testbb")
    public void receive2(ConsumerRecord<?, ?> consumer) {
        log.info("getMsg {} - {}:{}", consumer.topic(), consumer.key(), consumer.value());
    }
  }
