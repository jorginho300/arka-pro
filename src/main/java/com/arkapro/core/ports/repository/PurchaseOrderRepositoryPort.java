package com.arkapro.core.ports.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.arkapro.domain.model.PurchaseOrder;

public interface PurchaseOrderRepositoryPort {
	PurchaseOrder save (PurchaseOrder order);
	Optional<PurchaseOrder> findById(Long id);
	Optional<PurchaseOrder> findFullById(Long id);
	List<PurchaseOrder> findOrdersOldersThan(LocalDateTime limit);
}
