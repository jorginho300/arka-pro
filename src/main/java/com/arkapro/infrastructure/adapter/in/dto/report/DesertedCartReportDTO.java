package com.arkapro.infrastructure.adapter.in.dto.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DesertedCartReportDTO(Long orderId,
		String customerName,
		LocalDateTime createdAt,
		BigDecimal totalAmount) {

}
