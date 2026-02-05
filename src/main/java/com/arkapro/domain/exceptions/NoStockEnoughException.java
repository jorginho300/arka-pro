package com.arkapro.domain.exceptions;

public class NoStockEnoughException extends RuntimeException {
	public NoStockEnoughException(Long productId, Integer available, Integer requested) {
		super(String.format("No stock enough for id product %d. Available: %d, Requested: %d", productId, available, requested));
	}

}
