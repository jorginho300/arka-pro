package com.arkapro.infrastructure.adapter.out.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.arkapro.domain.model.PurchaseOrderStatusEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrderJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;
	@Column(name = "completed_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime completedAt;
	@Column(name = "total", nullable = false)
	private BigDecimal total;
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private PurchaseOrderStatusEnum status;
	@ManyToOne
	@JoinColumn(name = "fk_id_customer", nullable = false)
	private CustomerJpaEntity customer;
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseOrderDetailJpaEntity> details;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public PurchaseOrderStatusEnum getStatus() {
		return status;
	}
	public void setStatus(PurchaseOrderStatusEnum status) {
		this.status = status;
	}
	public CustomerJpaEntity getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerJpaEntity customer) {
		this.customer = customer;
	}
	public List<PurchaseOrderDetailJpaEntity> getDetails() {
		return details;
	}
	public void setDetails(List<PurchaseOrderDetailJpaEntity> details) {
		this.details = details;
	}
	
	
}
