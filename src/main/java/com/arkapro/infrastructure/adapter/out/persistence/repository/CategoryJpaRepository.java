package com.arkapro.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkapro.infrastructure.adapter.out.persistence.entity.CategoryJpaEntity;

public interface CategoryJpaRepository extends JpaRepository<CategoryJpaEntity, Long>{

}
