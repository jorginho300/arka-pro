package com.arkapro.infrastructure.adapter.in.dto.report;

public record TopSellingProductReportDTO(Long productId,
		String productName,
		Long totalSold
		) {
}
