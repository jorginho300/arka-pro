package com.arkapro.infrastructure.adapter.in.dto.request;

import java.util.List;

public class CreatePurchaseOrderCommandRequest {
	private Long customerId;
	private List<OrderItemsCommandRequest> items;
	
	public CreatePurchaseOrderCommandRequest() {
		
	}
	
	public CreatePurchaseOrderCommandRequest(List<OrderItemsCommandRequest> items) {
		this.items = items;
	}

	public CreatePurchaseOrderCommandRequest(Long customerId, List<OrderItemsCommandRequest> items) {
		this.customerId = customerId;
		this.items = items;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<OrderItemsCommandRequest> getItems() {
		return items;
	}

	public void setItems(List<OrderItemsCommandRequest> items) {
		this.items = items;
	}
	
	
	
	
}
