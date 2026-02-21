package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;
import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderJpaEntity;

@Mapper(componentModel = "spring",
uses = {
		CustomerMapper.class,
		PurchaseOrderDetailMapper.class
})
public interface PurchaseOrderMapper {
	@Mapping(target = "customer", source = "customer", qualifiedByName = "customerEntityToId")
	@Mapping(target = "details", source = "details")
	PurchaseOrder toDomain(PurchaseOrderJpaEntity entity);
	@Mapping(target = "customer", source = "customer", qualifiedByName = "customerIdToEntity")
	@Mapping(target = "details", source = "details")
	@Mapping(target = "status", source = "status")
	PurchaseOrderJpaEntity toEntity(PurchaseOrder domain);
	
	@Named("customerEntityToId")
	default Long customerEntityToId(CustomerJpaEntity customer) {
		if (customer == null) {
			return null;
		} else {
			return customer.getId();
		}
	}
	
	@Named("customerIdToEntity")
	default CustomerJpaEntity customerIdToEntity(Long id) {
		if(id == null) {
			return null;
		} else {
			CustomerJpaEntity entity = new CustomerJpaEntity();
			entity.setId(id);
			return entity;
		}
	}
}
