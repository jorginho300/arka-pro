package com.arkapro.core.ports.in;

import java.util.List;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.LowStockProductReportDTO;

public class GenerateLowStockReportUseCase {
	private final ReportQueryPort reportQuery;
	
	public GenerateLowStockReportUseCase(ReportQueryPort reportQuery) {
		this.reportQuery = reportQuery;
	}
	
	public List<LowStockProductReportDTO> execute(Integer threshold) {
		return reportQuery.findLowStockProducts(threshold);
	}
}
