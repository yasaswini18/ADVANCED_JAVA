package com.order_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {
	public static final String DIRECT_EXCHANGE="order.direct.exchange";
	public static final String PAYMENT_QUEUE="payment.queue";
	public static final String DIRECT_ROUTING_KEY="order.created";
	
	public static final String TOPIC_EXCHANGE="order.topic.exchange";
	public static final String ORDER_INDIA_QUEUE = "order.inida.queue";
	public static final String ORDER_USA_QUEUE = "order.usa.queue";
	public static final String TOPIC_ROUTING_INDIA = "order.india";
	public static final String TOPIC_ROUTING_USA ="order.usa";
	
	public static final String FAN_OUT_EXCHANGE="order.fanout.exchange";
	
	public static final String DLX_EXCHANGE = "dlx.exchange";
	public static final String DLQ_QUEUE = "payment.dlq";
	public static final String DLQ_ROUTING = "dlq.routing";
	
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(DIRECT_EXCHANGE);
	}
	@Bean
	public TopicExchange topicExchange()
	{
		return new TopicExchange(TOPIC_EXCHANGE);
	}
	@Bean
	public FanoutExchange fanoutExchange()
	{
		return new FanoutExchange(FAN_OUT_EXCHANGE);
	}
	@Bean
	public DirectExchange dlxExchange()
	{
		return new DirectExchange(DLX_EXCHANGE);
	}
//	@Bean
//	public Queue paymentQueue() {
//		return new Queue(PAYMENT_QUEUE);
//	}
	@Bean
	public Queue paymentDLQQueue() {
		return QueueBuilder.durable(PAYMENT_QUEUE)
				.withArgument("x-dead-letter-exchange", DLX_EXCHANGE)
				.withArgument("x-dead-letter-routing-key", DLQ_ROUTING)
				.build();
	}
	@Bean
	public Queue orderIndiaQueue()
	{
		return new Queue(ORDER_INDIA_QUEUE);
	}
	
	@Bean
	public Queue orderUsaQueue()
	{
		return new Queue(ORDER_USA_QUEUE);
	}
	@Bean
	public Queue deadLetterQueue()
	{
		return new Queue(DLQ_QUEUE);
	}
	@Bean
	public Binding directBinding()
	{
		return BindingBuilder
				 .bind(paymentDLQQueue())
				 .to(directExchange())
				 .with(DIRECT_ROUTING_KEY);
	}
	
	@Bean
	public Binding topicIndiaBinding()
	{
		return BindingBuilder
				.bind(orderIndiaQueue())
				.to(topicExchange())
				.with(TOPIC_ROUTING_INDIA);
	}
	
	@Bean
	public Binding topicUsaBinding()
	{
		return BindingBuilder
				.bind(orderUsaQueue())
				.to(topicExchange())
				.with(TOPIC_ROUTING_USA);
	}
	
	@Bean
	public Binding fanoutBinding1()
	{
		return BindingBuilder
				.bind(paymentDLQQueue())
				.to(fanoutExchange());
	}
	@Bean
	public Binding fanoutBinding2()
	{
		return BindingBuilder
				.bind(orderIndiaQueue())
				.to(fanoutExchange());
	}
	@Bean
	public Binding fanoutBinding3()
	{
		return BindingBuilder
				.bind(orderUsaQueue())
				.to(fanoutExchange());
	}
	@Bean
	public Binding dlqBinding()
	{
		return BindingBuilder
				.bind(deadLetterQueue())
				.to(dlxExchange())
				.with(DLQ_ROUTING);
	}
	 @Bean
	    public Jackson2JsonMessageConverter messageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }

}
