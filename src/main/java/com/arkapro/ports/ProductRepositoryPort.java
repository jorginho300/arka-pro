package com.arkapro.ports;

import java.util.Optional;

import com.arkapro.domain.model.Product;

public interface ProductRepositoryPort {
	Product save(Product product);
	Optional<Product> findById(Long id);
}
