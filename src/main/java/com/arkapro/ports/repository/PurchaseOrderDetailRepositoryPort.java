package com.arkapro.ports.repository;

import com.arkapro.domain.model.PurchaseOrderDetail;

public interface PurchaseOrderDetailRepositoryPort {
	PurchaseOrderDetail save(PurchaseOrderDetail detail);
}
