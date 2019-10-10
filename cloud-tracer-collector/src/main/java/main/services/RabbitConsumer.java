package main.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
//@EnableRabbit
//@RabbitListener(queues = "kxwQueue", containerFactory = "rabbitListenerContainerFactory")
public class RabbitConsumer {
    //@RabbitListener(containerFactory = "simpleRabbitListenerContainerFactoryTracing", queues="queue-second")
    @RabbitListener(queues="queue-hello")
    public void listen(@Payload String foo) {
        System.out.println(foo+"----------=======");
    }
}