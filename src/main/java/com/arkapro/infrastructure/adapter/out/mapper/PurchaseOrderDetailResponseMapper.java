package com.arkapro.infrastructure.adapter.out.mapper;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.arkapro.infrastructure.adapter.in.dto.response.PurchaseOrderDetailResponse;
import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderDetailJpaEntity;

@Mapper(componentModel = "spring")
public interface PurchaseOrderDetailResponseMapper {
	@Mapping(target = "productId", source = "product.id")
	@Mapping(target = "productName", source = "product.name")
	@Mapping(target = "subtotal", expression = "java(subtotalCalculation(entity))")
	PurchaseOrderDetailResponse toResponse(PurchaseOrderDetailJpaEntity entity);
	
	default BigDecimal subtotalCalculation(PurchaseOrderDetailJpaEntity entity) {
		return entity.getUnitPrice()
				.multiply(BigDecimal.valueOf(entity.getQuantity()));
	}
}
