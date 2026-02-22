package com.arkapro.infrastructure.adapter.out.persistence;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arkapro.core.ports.repository.CustomerRepositoryPort;
import com.arkapro.domain.model.Customer;
import com.arkapro.infrastructure.adapter.out.mapper.CustomerMapper;
import com.arkapro.infrastructure.adapter.out.persistence.repository.CustomerJpaRepository;

@Component
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {
	
	private final CustomerJpaRepository repository;
	private final CustomerMapper mapper;
	
	public CustomerRepositoryAdapter(CustomerJpaRepository repository, CustomerMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	@Override
	public Optional<Customer> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.map(mapper::toDomain);
	}
	
}
