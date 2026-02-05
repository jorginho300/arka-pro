package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;

import com.arkapro.domain.model.StockManagement;
import com.arkapro.infrastructure.adapter.out.persistence.entity.StockManagementJpaEntity;

@Mapper(componentModel = "spring")
public interface StockManagementMapper {
	
	StockManagement toDomain(StockManagementJpaEntity entity);
	StockManagementJpaEntity toEntity(StockManagement domain);
}
