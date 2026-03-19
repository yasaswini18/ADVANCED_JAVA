package com.payment_service.consumer;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Component;

import com.payment_service.dto.OrderCreatedEvent;

@Component
public class PaymentConsumer {
	
	@RabbitListener(queues = "payment.queue")
	@Retryable(
			retryFor   = Exception.class,
			maxAttempts = 3,
			backoff = @Backoff(delay=2000)
			)
	public void processPayment(OrderCreatedEvent event)
	{
		System.out.println("[DIRECT] Processing Payment for Order: "+event.getOrderId());
		System.out.println("[DIRECT] Amount: "+event.getAmount());
		
		if(event.getAmount()==-1)
		{
			System.out.println("[RETRY] Payment failed for Order: "+event.getOrderId()+" - retrying...");
			throw new RuntimeException("Payment failed - invalid amount for order: "+event.getOrderId());
		}
		System.out.println("[DIRECT] Payment Successful");
	}
	
	@Recover
	public void recover(RuntimeException ex,OrderCreatedEvent event)
	{
		System.out.println("===========================================================");
		System.out.println("[RECOVER] All 3 attempts failed for Order: "+event.getOrderId());
		System.out.println("[RECOVER] Reason: "+ex.getMessage());
		System.out.println("[RECOVER] Forwarding to DLQ...");
		System.out.println("===========================================================");
		
		throw new AmqpRejectAndDontRequeueException(ex);
	}
}
