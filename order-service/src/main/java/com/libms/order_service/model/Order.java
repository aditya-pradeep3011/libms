package com.libms.order_service.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "T_ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "ORDER_ID", updatable = false, nullable = false)
	private UUID orderId;
	
	@Column(name = "BOOK_ID", nullable = false)
	private UUID bookId;
	
	@Column(name = "BOOK_NAME", nullable = false)
	private String bookName;
	
	@Column(name = "USER_EMAIL", nullable = false)
	private String userEmail;
	
	@Column(name = "USER_FIRST_NAME")
	private String userFirstName;
	
	@Column(name = "USER_LAST_NAME")
	private String userLastName;
	
	@Column(name = "BOOK_PRICE")
	private Float bookPrice;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
}
