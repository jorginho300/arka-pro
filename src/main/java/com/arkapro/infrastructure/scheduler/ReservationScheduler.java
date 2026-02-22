package com.arkapro.infrastructure.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.arkapro.core.ports.in.DesertPurchaseOrderUseCase;

@Component
public class ReservationScheduler {
	
	private final DesertPurchaseOrderUseCase desertUC;
	
	public ReservationScheduler(DesertPurchaseOrderUseCase desertUC) {
		this.desertUC = desertUC;
	}
	
	@Scheduled(fixedRate = 3600000)
	public void desertPurchaseOrders() {
		desertUC.execute();
	}

}
