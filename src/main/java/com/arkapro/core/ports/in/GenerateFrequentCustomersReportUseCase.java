package com.arkapro.core.ports.in;

import java.util.List;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.FrequentCustomerReportDTO;

public class GenerateFrequentCustomersReportUseCase {
	private final ReportQueryPort reportQuery;
	
	public GenerateFrequentCustomersReportUseCase(ReportQueryPort reportQuery) {
		this.reportQuery = reportQuery;
	}
	
	public List<FrequentCustomerReportDTO> execute() {
		return reportQuery.findFrequentCustomers();
	}
}
