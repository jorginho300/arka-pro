package com.arkapro.domain.events;

import java.util.List;

public class ConfirmedPurchaseOrderEvent {
	private Long purchaseOrderId;
	private List<ProductPurchaseOrderEvent> products;
	
	public ConfirmedPurchaseOrderEvent() {
		
	}

	public ConfirmedPurchaseOrderEvent(Long purchaseOrderId, List<ProductPurchaseOrderEvent> products) {
		this.purchaseOrderId = purchaseOrderId;
		this.products = products;
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public List<ProductPurchaseOrderEvent> getProducts() {
		return products;
	}

	public void setProducts(List<ProductPurchaseOrderEvent> products) {
		this.products = products;
	}
	
	
}
