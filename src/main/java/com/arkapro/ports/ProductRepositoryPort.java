package com.arkapro.ports;

import com.arkapro.domain.model.Product;

public interface ProductRepositoryPort {
	Product save(Product product);
}
