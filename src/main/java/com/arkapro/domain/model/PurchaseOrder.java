package com.arkapro.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {
	private Long id;
	private Long customer;
	public void setCustomer(Long customer) {
		this.customer = customer;
	}

	private List<PurchaseOrderDetail> details = new ArrayList<>();
	private PurchaseOrderStatusEnum status;
	private LocalDateTime createdAt;
	private LocalDateTime completedAt;
	private BigDecimal total = BigDecimal.ZERO;
	
	public PurchaseOrder() {
		
	}
	
	public PurchaseOrder(Long customerId) {
		if(customerId == null) {
			throw new IllegalArgumentException("Customer cannot be null");
		} else {
			this.customer = customerId;
			this.details = new ArrayList<>();
			this.status = PurchaseOrderStatusEnum.PENDING;
			this.createdAt = LocalDateTime.now();
		}
	}
	
	public Long getCustomer() {
		return customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public PurchaseOrderStatusEnum getStatus() {
		return status;
	}

	public void setStatus(PurchaseOrderStatusEnum status) {
		this.status = status;
	}

	public List<PurchaseOrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<PurchaseOrderDetail> details) {
		this.details = details;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
	public void addDetail(Long productId, Integer quantity, BigDecimal unitPrice) {
		if(quantity <= 0) {
			throw new IllegalArgumentException("Invalid quantity");
		} else if(status != PurchaseOrderStatusEnum.PENDING) {
			throw new IllegalStateException("Cannot modify an order that is not in a pending status");
		} else {
			PurchaseOrderDetail detail = new PurchaseOrderDetail(productId, quantity, unitPrice);
			this.details.add(detail);
		}

	}
	
	public void confirmPurchaseOrder() {
		if(details.isEmpty()) {
			throw new IllegalStateException("Purchase order without products");
		} else {
			this.status = PurchaseOrderStatusEnum.CONFIRMED;
			
		}
	}
	
	public void desertPurchaseOrder() {
		this.status = PurchaseOrderStatusEnum.DESERTED;
		this.completedAt = LocalDateTime.now();
	}
	
	
	public Integer totalQuantityOfProductsCalculation() {
		return details.stream()
				.mapToInt(PurchaseOrderDetail::getQuantity)
				.sum();
	}
	
	public void totalCalculation() {
		this.total = details.stream()
				.map(PurchaseOrderDetail::getSubtotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
