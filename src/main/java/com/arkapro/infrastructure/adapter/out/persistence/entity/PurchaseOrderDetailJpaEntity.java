package com.arkapro.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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
}
