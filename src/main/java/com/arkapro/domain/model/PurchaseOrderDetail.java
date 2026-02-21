package com.arkapro.domain.model;

import java.math.BigDecimal;

public class PurchaseOrderDetail {
	private Long productId;
	private Integer quantity;
	private BigDecimal unitPrice;
	private BigDecimal subtotal;
	
	public PurchaseOrderDetail(Long productId, Integer quantity, BigDecimal unitPrice) {
		if(productId == null) {
			throw new IllegalArgumentException("Product cannot be null");
		}
		
		if(quantity == null || quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater than zero");
		} 
		
		if(unitPrice == null) {
			throw new IllegalArgumentException("Unit price is required");
			
		} else {
			this.productId = productId;
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}
	}

	public PurchaseOrderDetail() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getSubtotal() {
		return unitPrice.multiply(BigDecimal.valueOf(quantity));
	}
	
	public BigDecimal setSubtotal() {
		return subtotal;
	}
}
