package com.libms.order_service.mapper;

import com.libms.order_service.dto.OrderDto;
import com.libms.order_service.model.Order;

public class OrderMapper<T, U> implements Mapper<Order, OrderDto> {

	@Override
	public Order toEntity(OrderDto dto) {
		Order order = new Order();
		order.setBookId(dto.getBookId());
		order.setBookName(dto.getBookName());
		order.setUserEmail(dto.getUserEmail());
		order.setUserFirstName(dto.getUserFirstName());
		order.setUserLastName(dto.getUserLastName());
		order.setBookPrice(dto.getBookPrice());
		order.setQuantity(dto.getQuantity());
		return order;
	}

	@Override
	public OrderDto toDto(Order entity) {
		OrderDto orderDTO = new OrderDto();
		orderDTO.setOrderId(entity.getOrderId());
		orderDTO.setBookId(entity.getBookId());
		orderDTO.setBookName(entity.getBookName());
		orderDTO.setUserEmail(entity.getUserEmail());
		orderDTO.setUserFirstName(entity.getUserFirstName());
		orderDTO.setUserLastName(entity.getUserLastName());
		orderDTO.setBookPrice(entity.getBookPrice());
		orderDTO.setQuantity(entity.getQuantity());
		return orderDTO;
	}

}
