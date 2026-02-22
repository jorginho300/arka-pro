package com.arkapro.infrastructure.adapter.in.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.infrastructure.adapter.in.dto.request.CreatePurchaseOrderCommandRequest;
import com.arkapro.infrastructure.adapter.in.dto.request.OrderItemsCommandRequest;
import com.arkapro.infrastructure.adapter.in.dto.response.PurchaseOrderResponse;
import com.arkapro.infrastructure.adapter.out.assembler.PurchaseOrderResponseAssembler;
import com.arkapro.ports.in.ConfirmPurchaseOrderUseCase;
import com.arkapro.ports.in.CreatePurchaseOrderUseCase;
import com.arkapro.ports.in.DesertPurchaseOrderUseCase;
import com.arkapro.ports.in.RemoveItemsPurchaseOrderUseCase;

@RestController
@RequestMapping("/apiarkav2/orders")
public class PurchaseController {
	private final ConfirmPurchaseOrderUseCase purchaseOrderConfirmationUC;
	private final CreatePurchaseOrderUseCase purchaseOrderCreationUC;
	private final DesertPurchaseOrderUseCase desertOrdersUC;
	private final RemoveItemsPurchaseOrderUseCase removeItemsUC;
	private final PurchaseOrderResponseAssembler responseAssembler;
	
	public PurchaseController 
	(ConfirmPurchaseOrderUseCase purchaseOrderConfirmationUC, 
			CreatePurchaseOrderUseCase purchaseOrderCreationUC,
			PurchaseOrderResponseAssembler responseAssembler,
			DesertPurchaseOrderUseCase desertOrdersUC,
			RemoveItemsPurchaseOrderUseCase removeItemsUC) {
		this.purchaseOrderConfirmationUC = purchaseOrderConfirmationUC;
		this.purchaseOrderCreationUC = purchaseOrderCreationUC;
		this.desertOrdersUC = desertOrdersUC;
		this.removeItemsUC = removeItemsUC;
		this.responseAssembler = responseAssembler;
	}
	
	@PostMapping("/customer/{customerId}/create")
	public ResponseEntity<PurchaseOrderResponse> create
	(@PathVariable Long customerId, @RequestBody List<OrderItemsCommandRequest> orderItems) {
		CreatePurchaseOrderCommandRequest request = new CreatePurchaseOrderCommandRequest(customerId, orderItems);
		PurchaseOrder order = purchaseOrderCreationUC.execute(request);
		PurchaseOrderResponse response = responseAssembler.assemble(order);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/{id}/edit/remove")
	public ResponseEntity<PurchaseOrderResponse> editToRemoveItems(@PathVariable Long id, @RequestParam("product") Long productId) {
		PurchaseOrder order = removeItemsUC.execute(id, productId);
		PurchaseOrderResponse response = responseAssembler.assemble(order);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/{id}/confirm")
	public ResponseEntity<?> confirm(@PathVariable Long id) {
		purchaseOrderConfirmationUC.execute(id);
		return ResponseEntity.ok("Order has been confirmed");
	}
	
	@PostMapping("/admin/desert")
	public ResponseEntity<?> desertOrders() {
		desertOrdersUC.execute();
		return ResponseEntity.ok("Process has been executed");
	}
}
