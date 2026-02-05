package com.arkapro.ports;

import java.util.Optional;

import com.arkapro.domain.model.StockManagement;


public interface StockManagementRepositoryPort {
	Optional<StockManagement> findById(Long id);
	StockManagement save(StockManagement sm);
}
