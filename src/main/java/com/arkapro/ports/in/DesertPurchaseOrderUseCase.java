package com.arkapro.ports.in;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

public class DesertPurchaseOrderUseCase {
	private final PurchaseOrderRepositoryPort orderRepository;
	private final ProductRepositoryPort productRepository;
	private static final Duration EXPIRATION_THRESHOLD = Duration.ofHours(24);
	
	public DesertPurchaseOrderUseCase(PurchaseOrderRepositoryPort orderRepository, ProductRepositoryPort productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	public void execute() {
		LocalDateTime limit = LocalDateTime.now().minus(EXPIRATION_THRESHOLD);
		List<PurchaseOrder> expiredOrders = orderRepository.findOrdersOldersThan(limit);
		expiredOrders.forEach(order -> {
			order.getDetails().forEach(detail -> {
				Product product = productRepository.findById(detail.getProductId())
						.orElseThrow(() -> new RuntimeException("Product Not Found"));
				
				product.freeReservations(detail.getQuantity());
				productRepository.save(product);
			});
			
			order.desertPurchaseOrder();
			orderRepository.save(order);
		});
	}
}
