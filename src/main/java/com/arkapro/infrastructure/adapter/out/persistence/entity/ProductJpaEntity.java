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
@Table(name = "products")
public class ProductJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	@Column(name = "price", nullable = false)
	private BigDecimal price;
	@Column(name = "description", nullable = false, length = 100)
	private String description;
	@Column(name = "stock", nullable = false)
	private Integer stock;
	@Column(name = "reserved_stock", nullable = false)
	private Integer reservedStock;

	@ManyToOne
	@JoinColumn(name = "fk_id_category", nullable = false)
	private CategoryJpaEntity category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public CategoryJpaEntity getCategory() {
		return category;
	}
	public void setCategory(CategoryJpaEntity category) {
		this.category = category;
	}
	
	public Integer getReservedStock() {
		return reservedStock;
	}
	public void setReservedStock(Integer reservedStock) {
		this.reservedStock = reservedStock;
	}
}
