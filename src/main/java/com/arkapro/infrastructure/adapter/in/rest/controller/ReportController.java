package com.arkapro.infrastructure.adapter.in.rest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arkapro.core.ports.in.GenerateLowStockReportUseCase;
import com.arkapro.infrastructure.adapter.in.dto.report.LowStockProductReportDTO;

@RestController
@RequestMapping("/apiarkav2/reports")
public class ReportController {
	private final GenerateLowStockReportUseCase lowStockUC;
	
	public ReportController(GenerateLowStockReportUseCase lowStockUC) {
		this.lowStockUC = lowStockUC;
	}
	
	@GetMapping("/low-stock")
	public ResponseEntity<List<LowStockProductReportDTO>> lowStock(@RequestParam Integer threshold) {
		return ResponseEntity.ok(lowStockUC.execute(threshold));
	}
}
