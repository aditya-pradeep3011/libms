package com.libms.order_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libms.order_service.dto.OrderDto;
import com.libms.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto orderDto) {
		return new ResponseEntity<OrderDto>(orderService.placeOrder(orderDto), HttpStatus.CREATED);
	}
}
