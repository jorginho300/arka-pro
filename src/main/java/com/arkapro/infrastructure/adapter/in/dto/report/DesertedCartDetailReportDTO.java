package com.arkapro.infrastructure.adapter.in.dto.report;

import java.math.BigDecimal;

public record DesertedCartDetailReportDTO(Long productId,
		String productName,
		Integer quantity,
		BigDecimal unitPrice,
		BigDecimal subtotal) {

}
