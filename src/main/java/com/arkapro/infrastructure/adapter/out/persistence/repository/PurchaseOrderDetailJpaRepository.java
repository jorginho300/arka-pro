package com.arkapro.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderDetailJpaEntity;

public interface PurchaseOrderDetailJpaRepository extends JpaRepository<PurchaseOrderDetailJpaEntity, Long> {

}
