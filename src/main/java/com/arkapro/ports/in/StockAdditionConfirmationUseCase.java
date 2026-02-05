package com.arkapro.ports.in;

import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.StockManagement;
import com.arkapro.domain.model.StockManagementEnum;
import com.arkapro.ports.ProductRepositoryPort;
import com.arkapro.ports.StockManagementRepositoryPort;

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
		
		sm.setStatus(StockManagementEnum.APPROVED);
		product.increaseOrRestoreStock(sm.getQuantity());
		productRepository.save(product);
		stockRepository.save(sm);
	}
}
