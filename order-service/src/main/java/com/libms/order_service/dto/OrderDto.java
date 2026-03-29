package com.libms.order_service.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class OrderDto {

	private UUID orderId;
	private UUID bookId;
	private String bookName;
	private String userEmail;
	private String userFirstName;
	private String userLastName;
	private Float bookPrice;
	private Integer quantity;
	
}
