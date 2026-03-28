package com.libms.inventory_service.mapper;

import com.libms.inventory_service.dto.InventoryDto;
import com.libms.inventory_service.model.Inventory;

public class InventoryMapper<T, U> implements Mapper<Inventory, InventoryDto> {

	@Override
	public InventoryDto toDto(Inventory entity) {
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setBookId(entity.getBookId());
		inventoryDto.setBookTitle(entity.getBookTitle());
		inventoryDto.setQuantity(entity.getQuantity());
		inventoryDto.setPrice(entity.getPrice());
		return inventoryDto;
	}

	@Override
	public Inventory toEntity(InventoryDto dto) {
		Inventory inventory = new Inventory();
		inventory.setBookId(dto.getBookId());
		inventory.setBookTitle(dto.getBookTitle());
		inventory.setQuantity(dto.getQuantity());
		inventory.setPrice(dto.getPrice());
		return inventory;
	}

}
