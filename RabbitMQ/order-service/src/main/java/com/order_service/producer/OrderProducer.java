package com.order_service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.order_service.config.RabbitMQConfig;
import com.order_service.dto.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderProducer {
	//rabbit template is the core spring AMQP class used to send messages to RabbitMQ
	private final RabbitTemplate rabbitTemplate;
	
	public void sendToDirectExchange(OrderCreatedEvent event) {
		rabbitTemplate.convertAndSend(
				RabbitMQConfig.DIRECT_EXCHANGE,
				RabbitMQConfig.DIRECT_ROUTING_KEY,
				event
				);
	}
	public void sendToTopicExchange(OrderCreatedEvent event,String region)
	{
		String routingKey = "order."+region;
		rabbitTemplate.convertAndSend(
				RabbitMQConfig.TOPIC_EXCHANGE,
				routingKey,
				event
				);
	}
	public void sendToFanoutExchange(OrderCreatedEvent event)
	{
		rabbitTemplate.convertAndSend(RabbitMQConfig.FAN_OUT_EXCHANGE, "", event);
	}

}
