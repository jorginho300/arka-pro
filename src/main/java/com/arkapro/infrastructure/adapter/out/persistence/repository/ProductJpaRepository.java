package com.arkapro.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkapro.infrastructure.adapter.out.persistence.entity.ProductJpaEntity;

public interface ProductJpaRepository extends JpaRepository<ProductJpaEntity, Long>{

}
