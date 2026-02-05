package com.arkapro.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkapro.infrastructure.adapter.out.persistence.entity.StockManagementJpaEntity;

public interface StockManagementJpaRepository extends JpaRepository<StockManagementJpaEntity, Long> {

}
