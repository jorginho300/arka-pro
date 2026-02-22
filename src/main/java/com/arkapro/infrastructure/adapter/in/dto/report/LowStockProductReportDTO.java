package com.arkapro.infrastructure.adapter.in.dto.report;

public record LowStockProductReportDTO(
		Long productId,
		String productName,
		Integer availableStock) {
}
