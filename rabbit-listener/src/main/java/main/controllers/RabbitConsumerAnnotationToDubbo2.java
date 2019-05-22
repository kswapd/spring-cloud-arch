package main.controllers;

import javax.annotation.Resource;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//@RabbitListener(queues="queue-hello")

@Component
@RabbitListener(bindings = @QueueBinding(
		value = @Queue(value = "queue-hello", durable = "true"),
		exchange = @Exchange(value = "exchangeTracing", durable = "true", type = ExchangeTypes.TOPIC),
		key = "hollo"

))
public class RabbitConsumerAnnotationToDubbo2 {

	//@Resource
	// FooService fs;
	//@RabbitListener(containerFactory = "simpleRabbitListenerContainerFactoryTracing", queues="queue-second")
	// @RabbitListener(queues="queue-hello")
	@RabbitHandler
	public void listen(@Payload String foo) {
		System.out.println(foo + "222222----------=======");
		// fs.sayFoo("consumer...");
	}
}