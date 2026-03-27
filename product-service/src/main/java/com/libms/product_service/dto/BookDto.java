package com.libms.product_service.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class BookDto {
	
	private UUID id;

	private String title;
	
	private String author;
	
	private String publisher;
	
	private Integer publicationYear;
}
