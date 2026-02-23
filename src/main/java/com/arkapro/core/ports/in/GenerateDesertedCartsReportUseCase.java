package com.arkapro.core.ports.in;

import java.util.List;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartReportDTO;

public class GenerateDesertedCartsReportUseCase {
	private final ReportQueryPort reportQuery;
	
	public GenerateDesertedCartsReportUseCase(ReportQueryPort reportQuery) {
		this.reportQuery = reportQuery;
	}
	
	public List<DesertedCartReportDTO> execute() {
		return reportQuery.findDesertedCarts();
	}
}
