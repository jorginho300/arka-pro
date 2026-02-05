package com.arkapro.infrastructure.adapter.out.persistence.entity;

import java.time.LocalDateTime;

import com.arkapro.domain.model.StockManagementEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StockManagementEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private StockManagementEnum status;
	@Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime createdAt;
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@Column(name = "product_id", nullable = false)
	private Long productId;
}
