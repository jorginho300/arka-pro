package com.arkapro.handlers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.arkapro.core.ports.repository.ProductRepositoryPort;
import com.arkapro.domain.events.ConfirmedPurchaseOrderEvent;
import com.arkapro.domain.model.Product;

@Component
public class StockReservationHandler {
	private final ProductRepositoryPort productRepository;
	
	public StockReservationHandler(ProductRepositoryPort productRepository) {
		this.productRepository = productRepository;
	}
	/*
	@EventListener
	public void handle(ConfirmedPurchaseOrderEvent event) {
		event.getProducts().forEach(p -> {
			Product product = productRepository.findById(p.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
			product.stockReservation(p.getQuantity());
			productRepository.save(product);
		});
	}*/
}
