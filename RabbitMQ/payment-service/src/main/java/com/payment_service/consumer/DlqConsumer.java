package com.payment_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.payment_service.dto.OrderCreatedEvent;

@Component
public class DlqConsumer {
	
	@RabbitListener(queues = "payment.dlq")
	public void handleDeadLetter(OrderCreatedEvent event)
	{
		System.out.println("****************************************");
		System.out.println("[DLQ] Failed message received");
		System.out.println("[DLQ] Order ID : "+event.getOrderId());
		System.out.println("[DLQ] Amount : "+event.getAmount());
		System.out.println("[DLQ] All retries exhausted - needs manual intervention");
		System.out.println("****************************************");
	}
}
