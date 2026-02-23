package com.arkapro.core.ports.in;

import java.util.List;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.TopSellingProductReportDTO;

public class GenerateTopSalesReportUseCase {
	private final ReportQueryPort reportQuery;
	
	public GenerateTopSalesReportUseCase(ReportQueryPort reportQuery) {
		this.reportQuery = reportQuery;
	}
	
	public List<TopSellingProductReportDTO> execute() {
		return reportQuery.findTopSellingProducts();
	}
}
