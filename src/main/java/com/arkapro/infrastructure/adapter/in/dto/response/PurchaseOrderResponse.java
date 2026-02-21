package com.arkapro.infrastructure.adapter.in.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PurchaseOrderResponse {
	private Long purchaseOrderId;
	private Long customerId;
	private String customerName;
	private LocalDateTime purchaseOrderDate;
	private Integer productsQuantity;
	private BigDecimal total;
	private List<PurchaseOrderDetailResponse> details;
	
	public PurchaseOrderResponse() {
		
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDateTime getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(LocalDateTime purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}

	public Integer getProductsQuantity() {
		return productsQuantity;
	}

	public void setProductsQuantity(Integer productsQuantity) {
		this.productsQuantity = productsQuantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<PurchaseOrderDetailResponse> getDetails() {
		return details;
	}

	public void setDetails(List<PurchaseOrderDetailResponse> details) {
		this.details = details;
	}
	
	
}
