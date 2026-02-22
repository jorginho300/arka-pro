package com.arkapro.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arkapro.core.ports.repository.StockManagementRepositoryPort;
import com.arkapro.domain.model.StockManagement;
import com.arkapro.infrastructure.adapter.out.mapper.StockManagementMapper;
import com.arkapro.infrastructure.adapter.out.persistence.entity.StockManagementJpaEntity;
import com.arkapro.infrastructure.adapter.out.persistence.repository.StockManagementJpaRepository;

@Component
public class StockManagementRepositoryAdapter implements StockManagementRepositoryPort {
	
	private final StockManagementJpaRepository repository;
	private final StockManagementMapper mapper;
	
	public StockManagementRepositoryAdapter(StockManagementJpaRepository repository, StockManagementMapper mapper) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public Optional<StockManagement> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.map(mapper::toDomain);
	}

	@Override
	public StockManagement save(StockManagement sm) {
		// TODO Auto-generated method stub
		StockManagementJpaEntity entity = mapper.toEntity(sm);
		StockManagementJpaEntity saved = repository.save(entity);
		return mapper.toDomain(saved);
	}

}
