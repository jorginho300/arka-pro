package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;

import com.arkapro.domain.model.Product;
import com.arkapro.infrastructure.adapter.out.persistence.entity.ProductJpaEntity;

@Mapper(componentModel = "spring", 
uses = {
		CategoryMapper.class,
		StockManagementMapper.class
})
public interface ProductMapper {
	Product toDomain(ProductJpaEntity entity);
	ProductJpaEntity toEntity(Product domain);
}
