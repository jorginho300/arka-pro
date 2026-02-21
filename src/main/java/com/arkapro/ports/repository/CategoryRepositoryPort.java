package com.arkapro.ports.repository;

import java.util.Optional;

import com.arkapro.domain.model.Category;

public interface CategoryRepositoryPort {
	Optional<Category> findById(Long id);
}
