package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;

import com.arkapro.domain.model.Customer;
import com.arkapro.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	Customer toDomain(CustomerJpaEntity entity);

	default Long toId(CustomerJpaEntity entity) {
		return entity != null ? entity.getId() : null;
	}

	default CustomerJpaEntity toEntity(Long id) {
		if(id == null) {
			return null;
		} else {
			CustomerJpaEntity entity = new CustomerJpaEntity();
			entity.setId(id);
			return entity;
		}
	}
}
