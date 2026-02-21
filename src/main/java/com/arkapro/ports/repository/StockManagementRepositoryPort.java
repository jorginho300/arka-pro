package com.arkapro.ports.repository;

import java.util.Optional;

import com.arkapro.domain.model.StockManagement;


public interface StockManagementRepositoryPort {
	Optional<StockManagement> findById(Long id);
	StockManagement save(StockManagement sm);
}
