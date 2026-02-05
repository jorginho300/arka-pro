package com.arkapro.infrastructure.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.arkapro.domain.model.Product;
import com.arkapro.infrastructure.adapter.out.mapper.ProductMapper;
import com.arkapro.infrastructure.adapter.out.persistence.entity.ProductJpaEntity;
import com.arkapro.infrastructure.adapter.out.persistence.repository.ProductJpaRepository;
import com.arkapro.ports.ProductRepositoryPort;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
	
	private final ProductJpaRepository repository;
	private final ProductMapper mapper;
	
	public ProductRepositoryAdapter(ProductJpaRepository repository, ProductMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		ProductJpaEntity entity = mapper.toEntity(product);
		ProductJpaEntity saved = repository.save(entity);
		return mapper.toDomain(saved);
	}

}
