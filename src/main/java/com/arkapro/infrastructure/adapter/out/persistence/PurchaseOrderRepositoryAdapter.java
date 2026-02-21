package com.arkapro.infrastructure.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.infrastructure.adapter.out.mapper.PurchaseOrderMapper;
import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderJpaEntity;
import com.arkapro.infrastructure.adapter.out.persistence.repository.PurchaseOrderJpaRepository;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;

@Component
public class PurchaseOrderRepositoryAdapter implements PurchaseOrderRepositoryPort {
	
	private final PurchaseOrderJpaRepository repository;
	private final PurchaseOrderMapper mapper;
	
	public PurchaseOrderRepositoryAdapter(PurchaseOrderJpaRepository repository, PurchaseOrderMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public PurchaseOrder save(PurchaseOrder order) {
		// TODO Auto-generated method stub
		PurchaseOrderJpaEntity entity = mapper.toEntity(order);
		if(entity.getCustomer() == null || entity.getCustomer().getId() == null) {
			throw new IllegalStateException("Customer mapping failed. Order customerId: " + order.getCustomer()
			+ ", Entity customer: " + entity.getCustomer());
		}
		entity.getDetails().forEach(detail -> detail.setPurchaseOrder(entity));
		PurchaseOrderJpaEntity saved = repository.save(entity);
		return mapper.toDomain(saved);
	}

	@Override
	public Optional<PurchaseOrder> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.map(mapper::toDomain);
	}

	@Override
	public List<PurchaseOrder> findOrdersOldersThan(LocalDateTime limit) {
		// TODO Auto-generated method stub
		return repository.findOrdersOlderThan(limit)
				.stream()
				.map(mapper::toDomain)
				.toList();
	}

	@Override
	public Optional<PurchaseOrder> findFullById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.map(mapper::toDomain);
	}

}
