package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.domain.model.PurchaseOrderDetail;
import com.arkapro.infrastructure.adapter.in.dto.request.CreatePurchaseOrderCommandRequest;
import com.arkapro.infrastructure.adapter.in.dto.request.OrderItemsCommandRequest;

@Mapper(componentModel = "spring")
public interface PurchaseOrderCommandRequestMapper {
	@Mapping(source = "items", target = "details")
	PurchaseOrder toDomain(CreatePurchaseOrderCommandRequest commandRequest);
	@Mapping(source = "productId", target = "productId")
	PurchaseOrderDetail toDetail(OrderItemsCommandRequest orderItems);
}
