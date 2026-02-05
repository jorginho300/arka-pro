package com.arkapro.ports.in;

import java.time.LocalDateTime;

import com.arkapro.domain.model.StockManagement;
import com.arkapro.domain.model.StockManagementEnum;
import com.arkapro.ports.StockManagementRepositoryPort;

public class StockAdditionDemandUseCase {
	private final StockManagementRepositoryPort stockManagementRepository;
	
	public StockAdditionDemandUseCase(StockManagementRepositoryPort stockManagementRepository) {
		this.stockManagementRepository = stockManagementRepository;
	}
	
	public void execute(Long productId, Integer quantity) {
		StockManagement sm = new StockManagement();
		sm.setProductId(productId);
		sm.setQuantity(quantity);
		sm.setStatus(StockManagementEnum.PENDING);
		sm.setCreatedAt(LocalDateTime.now());
		stockManagementRepository.save(sm);
	}
}
