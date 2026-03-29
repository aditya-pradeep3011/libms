package com.libms.inventory_service.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.libms.inventory_service.dto.InventoryDto;
import com.libms.inventory_service.mapper.InventoryMapper;
import com.libms.inventory_service.model.Inventory;
import com.libms.inventory_service.repo.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

	private final InventoryRepository inventoryRepository;
	private final InventoryMapper<Inventory, InventoryDto> inventoryMapper;
	
	public Optional<InventoryDto> getStockInfo(UUID bookId)
	{
		return inventoryRepository.findById(bookId).map(inventoryMapper::toDto);
	}
	
	public boolean isInStock(UUID bookId, int quantity) {
		Optional<Inventory> inventoryOpt = inventoryRepository.findById(bookId);
		return inventoryOpt.map(inventory -> inventory.getQuantity() >= quantity).orElse(false);
	}
}
