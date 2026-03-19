package com.order_service.service;

import org.springframework.stereotype.Service;

import com.order_service.dto.OrderCreatedEvent;
import com.order_service.dto.OrderRequestDTO;
import com.order_service.dto.OrderResponseDTO;
import com.order_service.entity.Order;
import com.order_service.producer.OrderProducer;
import com.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
private final OrderRepository orderRepository;

private final OrderProducer orderProducer;

public OrderResponseDTO createOrder(OrderRequestDTO dto)
{
	Order order = new Order();
	order.setProductName(dto.getProductName());
	order.setQuantity(dto.getQuantity());
	order.setPrice(dto.getPrice());
	order.setStatus("CREATED");
	Order saved = orderRepository.save(order);
	
	OrderCreatedEvent event = new OrderCreatedEvent(saved.getId(),saved.getPrice());
	
	orderProducer.sendToDirectExchange(event);
	orderProducer.sendToTopicExchange(event, dto.getRegion());
	orderProducer.sendToFanoutExchange(event);
	return new OrderResponseDTO(saved.getId(),"ORDER_CREATED");
}
}
