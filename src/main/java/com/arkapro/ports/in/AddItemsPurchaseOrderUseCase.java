package com.arkapro.ports.in;

import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.infrastructure.adapter.in.dto.request.CreatePurchaseOrderCommandRequest;
import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

public class AddItemsPurchaseOrderUseCase {
	private final PurchaseOrderRepositoryPort purchaseOrderRepository;
	private final ProductRepositoryPort productRepository;
	
	public AddItemsPurchaseOrderUseCase(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
		this.productRepository = productRepository;
	}
	
	public PurchaseOrder execute(Long orderId, CreatePurchaseOrderCommandRequest request) {
		PurchaseOrder order = purchaseOrderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("Purchase Order not found"));
		
		order.getDetails().forEach(d -> {
			Product product = productRepository.findById(d.getProductId())
					.orElseThrow(() -> new IllegalArgumentException("Some products weren't found in current purchase order"));
			
			product.freeReservations(d.getQuantity());
			productRepository.save(product);
		});
		
		order.clearDetails();
		request.getItems().forEach(item -> {
			Product product = productRepository.findById(item.getProductId())
					.orElseThrow(() -> new IllegalArgumentException("Product not found"));
			
			product.stockReservation(item.getQuantity());
			productRepository.save(product);
			order.addDetail(item.getProductId(), item.getQuantity(), product.getPrice());
		});
		
		order.totalCalculation();
		return purchaseOrderRepository.save(order);
	}
}
