package com.libms.inventory_service.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class InventoryDto {
	
	private UUID bookId;
	
	private String bookTitle;
	
	private Integer quantity;
	
	private Float price;
}
