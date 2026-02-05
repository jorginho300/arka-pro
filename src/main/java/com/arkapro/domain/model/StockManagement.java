package com.arkapro.domain.model;

import java.time.LocalDateTime;

public class StockManagement {
	private Long id;
	private StockManagementEnum status;
	private LocalDateTime createdAt;
	private Integer quantity;
	private Long productId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StockManagementEnum getStatus() {
		return status;
	}
	public void setStatus(StockManagementEnum status) {
		this.status = status;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	

}
