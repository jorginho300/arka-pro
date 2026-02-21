package com.arkapro.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order_detail")
public class PurchaseOrderDetailJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "fk_id_purchase_order", nullable = false)
	private PurchaseOrderJpaEntity purchaseOrder;
	@ManyToOne
	@JoinColumn(name = "fk_id_product", nullable = false)
	private ProductJpaEntity product;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "unit_price", nullable = false)
	private BigDecimal unitPrice;
	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PurchaseOrderJpaEntity getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrderJpaEntity purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public ProductJpaEntity getProduct() {
		return product;
	}
	public void setProduct(ProductJpaEntity product) {
		this.product = product;
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
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
