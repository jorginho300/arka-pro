package com.arkapro.core.ports.in;

import com.arkapro.core.ports.repository.ProductRepositoryPort;
import com.arkapro.core.ports.repository.StockManagementRepositoryPort;
import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.StockManagement;
import com.arkapro.domain.model.StockManagementEnum;

public class StockAdditionConfirmationUseCase {
	private final ProductRepositoryPort productRepository;
	private final StockManagementRepositoryPort stockRepository;
	
	public StockAdditionConfirmationUseCase(ProductRepositoryPort productRepository, StockManagementRepositoryPort stockRepository) {
		this.productRepository = productRepository;
		this.stockRepository = stockRepository;
	}
	
	public void execute(Long stockMovementId) {
		StockManagement sm = stockRepository.findById(stockMovementId)
				.orElseThrow(() -> new RuntimeException("Stock Addition Demand Not Found"));
		
		Product product = productRepository.findById(sm.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));
		if(sm.getStatus() != StockManagementEnum.PENDING) {
			throw new IllegalStateException("Only requests in pending status can be approved");
		} else {
			sm.setStatus(StockManagementEnum.APPROVED);
			product.increaseStock(sm.getQuantity());
			productRepository.save(product);
			stockRepository.save(sm);
		}
	}
}
