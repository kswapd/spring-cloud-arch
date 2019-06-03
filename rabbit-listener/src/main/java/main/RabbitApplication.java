package main;

import javax.annotation.Resource;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@ImportResource(value = {"classpath:META-INF/spring/*.xml"})
@SpringBootApplication
public class RabbitApplication {


	static final String topicExchangeName = "exchangeTracing";

	static final String queueName = "spring-boot";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("hello");
	}

	/*@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}*/

	/*@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter, SimpleRabbitListenerContainerFactory fact) {
		//SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		//SimpleRabbitListenerContainerFactory fact = SpringApplicationContext.getContext().getBean(SimpleRabbitListenerContainerFactory.class);
		SimpleMessageListenerContainer container = fact.createListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);

		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		//SimpleRabbitListenerContainerFactory fact = SpringApplicationContext.getContext().getBean(SimpleRabbitListenerContainerFactory.class);
		//SimpleMessageListenerContainer container = fact.createListenerContainer();
		//container.setMessageListener(adapt);


		MessageListenerAdapter adapt = new MessageListenerAdapter(receiver, "receiveMessage");


		return adapt;
	}*/

	@Resource
	private RabbitTemplate rabbitTemplate;


	public static void main(String[] args) {

		System.out.println("Rabbit started...");
		SpringApplication.run(RabbitApplication.class, args);
		System.out.println("Rabbit started...222");


	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
