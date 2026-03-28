package com.libms.inventory_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.libms.inventory_service.dto.InventoryDto;
import com.libms.inventory_service.mapper.InventoryMapper;
import com.libms.inventory_service.model.Inventory;

@Configuration
public class MapperConfig {

	@Bean
	InventoryMapper<Inventory, InventoryDto> inventoryMapper()
	{
		return new InventoryMapper<Inventory, InventoryDto>();
	}
}
