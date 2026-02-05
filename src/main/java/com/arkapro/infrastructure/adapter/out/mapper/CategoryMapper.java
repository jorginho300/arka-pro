package com.arkapro.infrastructure.adapter.out.mapper;

import org.mapstruct.Mapper;

import com.arkapro.domain.model.Category;
import com.arkapro.infrastructure.adapter.out.persistence.entity.CategoryJpaEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	
	Category toDomain(CategoryJpaEntity entity);
	CategoryJpaEntity toModel(Category domain);
}
