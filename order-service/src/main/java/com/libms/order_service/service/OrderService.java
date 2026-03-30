package com.libms.order_service.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.libms.common_events.event.OrderPlacedEvent;
import com.libms.order_service.client.InventoryClient;
import com.libms.order_service.dto.OrderDto;
import com.libms.order_service.mapper.Mapper;
import com.libms.order_service.model.Order;
import com.libms.order_service.repo.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final Mapper<Order, OrderDto> orderMapper;
	private final InventoryClient inventoryClient;
	private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
	
	public OrderDto placeOrder(OrderDto orderDto) {
		
		//Check if item is in stock by calling inventory service
		boolean isInStock = inventoryClient.isInStock(orderDto.getBookId(), orderDto.getQuantity());
		
		//If in stock, save order to database
		if(isInStock)
		{
			Order order = orderMapper.toEntity(orderDto);
			Order savedOrder = orderRepository.save(order);
			
			OrderPlacedEvent event = new OrderPlacedEvent();
			event.setOrderId(savedOrder.getOrderId().toString());
			event.setBookName(orderDto.getBookName());
			event.setUserEmail(orderDto.getUserEmail());
			event.setUserFirstName(orderDto.getUserFirstName());
			event.setUserLastName(orderDto.getUserLastName());	
			
			kafkaTemplate.send("order-placed", event);
			return orderMapper.toDto(savedOrder);
		}
		else 
		{
			throw new RuntimeException("Book is out of stock");
		}
	}
}
