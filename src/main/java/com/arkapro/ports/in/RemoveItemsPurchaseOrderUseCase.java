package com.arkapro.ports.in;

import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.domain.model.PurchaseOrderDetail;
import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

public class RemoveItemsPurchaseOrderUseCase {
	private final PurchaseOrderRepositoryPort purchaseOrderRepository;
	private final ProductRepositoryPort productRepository;
	
	public RemoveItemsPurchaseOrderUseCase(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
		this.productRepository = productRepository;
	}
	
	public PurchaseOrder execute(Long orderId, Long productId) {
		PurchaseOrder order = purchaseOrderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("Purchase Order Not Found"));
		
		PurchaseOrderDetail removedDetail = order.removeDetail(productId);
		Product product = productRepository.findById(removedDetail.getProductId())
				.orElseThrow(() -> new IllegalArgumentException("Product not found in current purchase order"));
		
		product.freeReservations(removedDetail.getQuantity());
		productRepository.save(product);
		order.totalCalculation();
		return purchaseOrderRepository.save(order);
	}
}
