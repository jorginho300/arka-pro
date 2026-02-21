package com.arkapro.ports.in;

import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

public class UpdatePurchaseOrderUseCase {
	private final PurchaseOrderRepositoryPort purchaseOrderRepository;
	private final ProductRepositoryPort productRepository;
	
	public UpdatePurchaseOrderUseCase(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
		this.productRepository = productRepository;
	}
}
