package com.libms.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.libms.order_service.dto.OrderDto;
import com.libms.order_service.mapper.Mapper;
import com.libms.order_service.mapper.OrderMapper;
import com.libms.order_service.model.Order;

@Configuration
public class MapperConfig {

	@Bean
	Mapper<Order, OrderDto> mapper()
	{
		return new OrderMapper<Order, OrderDto>();
	}
}
