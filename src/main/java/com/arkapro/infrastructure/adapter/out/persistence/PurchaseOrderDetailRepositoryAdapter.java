package com.arkapro.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.arkapro.core.ports.repository.PurchaseOrderDetailRepositoryPort;
import com.arkapro.domain.model.PurchaseOrderDetail;
import com.arkapro.infrastructure.adapter.out.mapper.PurchaseOrderDetailMapper;
import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderDetailJpaEntity;
import com.arkapro.infrastructure.adapter.out.persistence.repository.PurchaseOrderDetailJpaRepository;

@Component
public class PurchaseOrderDetailRepositoryAdapter implements PurchaseOrderDetailRepositoryPort {
	private final PurchaseOrderDetailJpaRepository repository;
	private final PurchaseOrderDetailMapper mapper;
	
	public PurchaseOrderDetailRepositoryAdapter(PurchaseOrderDetailJpaRepository repository, PurchaseOrderDetailMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	

	@Override
	public PurchaseOrderDetail save(PurchaseOrderDetail detail) {
		// TODO Auto-generated method stub
		PurchaseOrderDetailJpaEntity entity = mapper.toEntity(detail);
		PurchaseOrderDetailJpaEntity saved = repository.save(entity);
		return mapper.toDomain(saved);
	}

}
