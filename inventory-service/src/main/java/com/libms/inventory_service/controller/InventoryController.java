package com.libms.inventory_service.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libms.inventory_service.dto.InventoryDto;
import com.libms.inventory_service.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;
	
	@GetMapping("{bookId}")
	public ResponseEntity<InventoryDto> getStockInfo(@PathVariable UUID bookId)
	{
		return inventoryService.getStockInfo(bookId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("{bookId}/stock")
	public boolean isInStock(@PathVariable UUID bookId, @RequestParam int quantity) {
		return inventoryService.isInStock(bookId, quantity);
	}
}
