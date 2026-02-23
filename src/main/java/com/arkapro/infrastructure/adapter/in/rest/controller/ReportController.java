package com.arkapro.infrastructure.adapter.in.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arkapro.core.ports.in.GenerateDesertedCartsDetailReportUseCase;
import com.arkapro.core.ports.in.GenerateDesertedCartsReportUseCase;
import com.arkapro.core.ports.in.GenerateFrequentCustomersReportUseCase;
import com.arkapro.core.ports.in.GenerateLowStockReportUseCase;
import com.arkapro.core.ports.in.GenerateTopSalesReportUseCase;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartDetailReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.FrequentCustomerReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.LowStockProductReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.TopSellingProductReportDTO;

@RestController
@RequestMapping("/apiarkav2/reports")
public class ReportController {
	private final GenerateLowStockReportUseCase lowStockUC;
	private final GenerateTopSalesReportUseCase topSalesUC;
	private final GenerateFrequentCustomersReportUseCase frequentCustomersUC;
	private final GenerateDesertedCartsReportUseCase desertedCartsUC;
	private final GenerateDesertedCartsDetailReportUseCase desertedCartsDetailUC;
	
	public ReportController(GenerateLowStockReportUseCase lowStockUC,
			GenerateTopSalesReportUseCase topSalesUC,
			GenerateFrequentCustomersReportUseCase frequentCustomersUC,
			GenerateDesertedCartsReportUseCase desertedCartsUC,
			GenerateDesertedCartsDetailReportUseCase desertedCartsDetailUC) {
		this.lowStockUC = lowStockUC;
		this.topSalesUC = topSalesUC;
		this.frequentCustomersUC = frequentCustomersUC;
		this.desertedCartsUC = desertedCartsUC;
		this.desertedCartsDetailUC = desertedCartsDetailUC;
	}
	
	@GetMapping("/low-stock")
	public ResponseEntity<List<LowStockProductReportDTO>> lowStock(@RequestParam Integer threshold) {
		return ResponseEntity.ok(lowStockUC.execute(threshold));
	}
	
	@GetMapping("/top-products")
	public ResponseEntity<List<TopSellingProductReportDTO>> topSales() {
		return ResponseEntity.ok(topSalesUC.execute());
	}
	
	@GetMapping("/top-customers")
	public ResponseEntity<List<FrequentCustomerReportDTO>> frequentCustomers() {
		return ResponseEntity.ok(frequentCustomersUC.execute());
	}
	
	@GetMapping("/carts-deserted")
	public ResponseEntity<List<DesertedCartReportDTO>> desertedCarts() {
		return ResponseEntity.ok(desertedCartsUC.execute());
	}
	
	@GetMapping("/carts-deserted/{id}")
	public ResponseEntity<List<DesertedCartDetailReportDTO>> desertedCartDetail(@PathVariable Long id) {
		return ResponseEntity.ok(desertedCartsDetailUC.execute(id));
	}
}
