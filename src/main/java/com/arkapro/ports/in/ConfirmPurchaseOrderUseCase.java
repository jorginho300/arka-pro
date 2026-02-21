package com.arkapro.ports.in;

import java.time.LocalDateTime;

import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.domain.model.PurchaseOrderStatusEnum;
import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

public class ConfirmPurchaseOrderUseCase {
	private final PurchaseOrderRepositoryPort purchaseOrderRepository;
	private final ProductRepositoryPort productRepository;
	
	public ConfirmPurchaseOrderUseCase(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
		this.productRepository = productRepository;
	}
	
	public void execute(Long purchaseOrderId) {
		PurchaseOrder order = purchaseOrderRepository.findById(purchaseOrderId)
				.orElseThrow(() -> new RuntimeException("Purchase Order Not Found"));
		
		if(order.getStatus() != PurchaseOrderStatusEnum.PENDING) {
			throw new IllegalStateException("This ID Order isn't in a pending state");
		} else {
			order.getDetails().forEach(detail -> {
				Product product = productRepository.findById(detail.getProductId())
						.orElseThrow(() -> new RuntimeException("Product not found"));
				
				order.setCompletedAt(LocalDateTime.now());				
				product.confirmReservation(detail.getQuantity());
				productRepository.save(product);
			});
		}
		
		order.confirmPurchaseOrder();
		purchaseOrderRepository.save(order);
	}
}
