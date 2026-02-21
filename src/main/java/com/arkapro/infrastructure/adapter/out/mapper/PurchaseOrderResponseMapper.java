package com.arkapro.infrastructure.adapter.out.mapper;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.domain.model.PurchaseOrderDetail;
import com.arkapro.infrastructure.adapter.in.dto.response.PurchaseOrderResponse;
import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderJpaEntity;

@Mapper(componentModel = "spring",
uses = {
		PurchaseOrderDetailResponseMapper.class,
		CustomerMapper.class,
		ProductMapper.class
})
public interface PurchaseOrderResponseMapper {
	@Mapping(target = "purchaseOrderId", source = "id")
	@Mapping(target = "customerId", source = "customer")
	@Mapping(target = "purchaseOrderDate", source = "createdAt")
	@Mapping(target = "productsQuantity", expression = "java(productsQuantityCalculation(order))")
	//@Mapping(target = "total", expression = "java(totalCalculation(entity))")
	PurchaseOrderResponse toResponse(PurchaseOrder order);
	
	default Integer productsQuantityCalculation(PurchaseOrder order) {
		return order.getDetails()
				.stream()
				.mapToInt(PurchaseOrderDetail::getQuantity)
				.sum();
	}
	
	default BigDecimal totalCalculation(PurchaseOrderJpaEntity entity) {
		return entity.getDetails()
				.stream()
				.map(detail -> 
				detail.getUnitPrice()
				.multiply(BigDecimal.valueOf(detail.getQuantity())))
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
