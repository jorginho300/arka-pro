package com.arkapro.core.ports.in;

import java.util.List;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartDetailReportDTO;

public class GenerateDesertedCartsDetailReportUseCase {
	private final ReportQueryPort reportQuery;
	
	public GenerateDesertedCartsDetailReportUseCase(ReportQueryPort reportQuery) {
		this.reportQuery = reportQuery;
	}
	
	public List<DesertedCartDetailReportDTO> execute(Long orderId) {
		return reportQuery.findDesertedCartDetail(orderId);
	}
}
