package com.arkapro.ports.in;

import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.infrastructure.adapter.in.dto.request.CreatePurchaseOrderCommandRequest;
import com.arkapro.ports.repository.CustomerRepositoryPort;
import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

public class CreatePurchaseOrderUseCase {
	private final PurchaseOrderRepositoryPort purchaseOrderRepository;
	private final CustomerRepositoryPort customerRepository;
	private final ProductRepositoryPort productRepository;
	
	public CreatePurchaseOrderUseCase
	(PurchaseOrderRepositoryPort purchaseOrderRepository, 
			CustomerRepositoryPort customerRepository, 
			ProductRepositoryPort productRepository) {
		this.purchaseOrderRepository = purchaseOrderRepository;
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
	}
	
	public PurchaseOrder execute(CreatePurchaseOrderCommandRequest request) {
		if(!customerRepository.existsById(request.getCustomerId())) {
			throw new IllegalArgumentException("Customer not found");
		} else {
			PurchaseOrder order = new PurchaseOrder(request.getCustomerId());
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
}
