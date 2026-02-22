package com.arkapro.infrastructure.adapter.in.dto.report;

import java.time.LocalDateTime;

public record DesertedCartReportDTO(Long orderId,
		String customerName,
		LocalDateTime createdAt) {

}
