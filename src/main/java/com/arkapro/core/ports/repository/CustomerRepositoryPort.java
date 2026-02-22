package com.arkapro.core.ports.repository;

import java.util.Optional;

import com.arkapro.domain.model.Customer;

public interface CustomerRepositoryPort {
	boolean existsById(Long id);
	Optional<Customer> findById(Long id);
}
