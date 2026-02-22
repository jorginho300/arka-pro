package com.arkapro.infrastructure.adapter.in.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arkapro.core.ports.in.StockAdditionConfirmationUseCase;
import com.arkapro.core.ports.in.StockAdditionDemandUseCase;

@RestController
@RequestMapping("/apiarkav2/supply")
public class StockManagementController {
	
	private final StockAdditionConfirmationUseCase additionConfirmationUC;
	private final StockAdditionDemandUseCase additionDemandUC;
	
	public StockManagementController(StockAdditionConfirmationUseCase additionConfirmationUC, StockAdditionDemandUseCase additionDemandUC) {
		this.additionConfirmationUC = additionConfirmationUC;
		this.additionDemandUC = additionDemandUC;
	}
	
	@PostMapping("/{productId}/")
	public ResponseEntity<?> supply(@PathVariable Long productId, @RequestParam("stock") int demand) {
		additionDemandUC.execute(productId, demand);
		return ResponseEntity.ok("Demanded");
	}
	
	@PatchMapping("/{stockManagementId}/confirm")
	public ResponseEntity<?> confirm(@PathVariable Long stockManagementId) {
		additionConfirmationUC.execute(stockManagementId);
		return ResponseEntity.ok("Confirmed");
	}

}