package com.arkapro.infrastructure.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arkapro.domain.model.Category;
import com.arkapro.infrastructure.adapter.out.mapper.CategoryMapper;
import com.arkapro.infrastructure.adapter.out.persistence.repository.CategoryJpaRepository;
import com.arkapro.ports.CategoryRepositoryPort;

@Component
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {
	
	private final CategoryJpaRepository repository;
	private final CategoryMapper mapper;
	
	public CategoryRepositoryAdapter(CategoryJpaRepository repository, CategoryMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Optional<Category> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.map(mapper::toDomain);
	}

}
