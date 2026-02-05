package com.arkapro.infrastructure.adapter.out.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "mobile_phone", nullable = false)
	private String mobilePhone;
	@Column(name = "email", nullable = false)
	private String email;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PurchaseOrderJpaEntity> purchaseOrders;
}
