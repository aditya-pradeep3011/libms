package com.libms.order_service.client;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {

	@GetExchange("/api/inventory/{bookId}/stock")
	public boolean isInStock(@PathVariable UUID bookId, @RequestParam Integer quantity);
}
