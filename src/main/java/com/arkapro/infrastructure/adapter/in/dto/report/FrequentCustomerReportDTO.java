package com.arkapro.infrastructure.adapter.in.dto.report;

import java.math.BigDecimal;

public record FrequentCustomerReportDTO(Long customerId,
		String customerName,
		Long totalOrders,
		BigDecimal totalAmountSpent) {

}
