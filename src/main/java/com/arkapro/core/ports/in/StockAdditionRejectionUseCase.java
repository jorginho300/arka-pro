package com.arkapro.core.ports.in;

import com.arkapro.core.ports.repository.StockManagementRepositoryPort;
import com.arkapro.domain.model.StockManagement;
import com.arkapro.domain.model.StockManagementEnum;

public class StockAdditionRejectionUseCase {
	private final StockManagementRepositoryPort stockRepository;
	
	public StockAdditionRejectionUseCase(StockManagementRepositoryPort stockRepository) {
		this.stockRepository = stockRepository;
	}
	
	public void execute(Long stockMovementId) {
		StockManagement sm = stockRepository.findById(stockMovementId)
				.orElseThrow(() -> new RuntimeException("Stock Addition Demand Not Found"));
		
		if(sm.getStatus() != StockManagementEnum.PENDING) {
			throw new IllegalStateException("Only requests in pending status can be rejected");
		} else {
			sm.setStatus(StockManagementEnum.REJECTED);
			stockRepository.save(sm);
		}

	}
}
