package com.arkapro.core.ports.repository;

import com.arkapro.domain.model.PurchaseOrderDetail;

public interface PurchaseOrderDetailRepositoryPort {
	PurchaseOrderDetail save(PurchaseOrderDetail detail);
}
