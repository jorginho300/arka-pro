package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.arkapro.domain.model.PurchaseOrderDetail;
import com.arkapro.infrastructure.adapter.out.persistence.entity.ProductJpaEntity;
import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderDetailJpaEntity;

@Mapper(componentModel = "spring")
public interface PurchaseOrderDetailMapper {
	@Mapping(target = "productId", source = "product", qualifiedByName = "productEntityToId")
	PurchaseOrderDetail toDomain(PurchaseOrderDetailJpaEntity entity);
	@Mapping(target = "product", source = "productId", qualifiedByName = "productIdToEntity")
	@Mapping(target = "purchaseOrder", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "subtotal", expression = "java(domain.getSubtotal())")
	PurchaseOrderDetailJpaEntity toEntity(PurchaseOrderDetail domain);
	
	@Named("productIdToEntity")
	default ProductJpaEntity map(Long productId) {
		if(productId == null) {
			return null;
		} else {
			ProductJpaEntity product = new ProductJpaEntity();
			product.setId(productId);
			return product;
		}
	}
	
	@Named("productEntityToId")
	default Long m(ProductJpaEntity entity) {
		if(entity == null) {
			return null;
		} else {
			return entity.getId();
		}
	}
}
