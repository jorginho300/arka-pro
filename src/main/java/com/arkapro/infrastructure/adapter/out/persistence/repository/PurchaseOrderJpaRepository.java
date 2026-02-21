package com.arkapro.infrastructure.adapter.out.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arkapro.infrastructure.adapter.out.persistence.entity.PurchaseOrderJpaEntity;

public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrderJpaEntity, Long> {
	@Query("""
			SELECT po
			FROM PurchaseOrderJpaEntity po
			JOIN FETCH po.customer
			JOIN FETCH po.details d
			JOIN FETCH d.product
			WHERE po.id = :id
			""")
	Optional<PurchaseOrderJpaEntity> findFullById(Long id);
	
	@Query("""
			SELECT po
			FROM PurchaseOrderJpaEntity po
			WHERE po.status = 'PENDING'
			AND po.createdAt <= :limit
			""")
	List<PurchaseOrderJpaEntity> findOrdersOlderThan(LocalDateTime limit);
}
