package com.arkapro.domain.model;

import java.math.BigDecimal;

import com.arkapro.domain.exceptions.NoStockEnoughException;

public class Product {
	private Long id;
	private String name;
	private BigDecimal price;
	private Category category;
	private Integer stock;
	private Integer reservedStock;
	private String description;
	


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Product() {
		
	}
	
	

	public Product(String name, BigDecimal price, Integer stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.reservedStock = 0;
	}
	
	



	public Integer getReservedStock() {
		return reservedStock;
	}



	public void setReservedStock(Integer reservedStock) {
		this.reservedStock = reservedStock;
	}



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Integer getAvailableStock() {
		return stock - reservedStock;
	}
	
	public void stockReservation(Integer quantity) {
		checkQuantity(quantity);
		
		if(getAvailableStock() < quantity) {
			throw new NoStockEnoughException(this.id, getAvailableStock(), quantity);
		} else {
			this.reservedStock += quantity;
		}
	}
	
	public void freeReservedStock(Integer quantity) {
		checkQuantity(quantity);
		this.reservedStock = Math.max(0, this.reservedStock - quantity);
	}
	
	public void confirmReservation(Integer quantity) {
		checkQuantity(quantity);
		
		if(this.reservedStock < quantity) {
			throw new IllegalStateException(String.format
					("No reserved stock enough. Reserved: %d, Required: %d", this.reservedStock, quantity));
		} else {
			this.stock -= quantity;
			this.reservedStock -= quantity;
		}
	}
	
	public void increaseOrRestoreStock(Integer quantity) {
		checkQuantity(quantity);
		this.stock += quantity;
	}
	
	private void checkQuantity(Integer quantity) {
		if(quantity == null || quantity <= 0) {
			throw new IllegalArgumentException("Quantity must be greater than zero");
		}
	}
}
