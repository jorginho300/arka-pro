package com.arkapro.core.ports.query;

import java.util.List;

import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartDetailReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.FrequentCustomerReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.LowStockProductReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.TopSellingProductReportDTO;

public interface ReportQueryPort {
	List<LowStockProductReportDTO> findLowStockProducts(Integer threshold);
	List<TopSellingProductReportDTO> findTopSellingProducts();
	List<FrequentCustomerReportDTO> findFrequentCustomers();
	List<DesertedCartReportDTO> findDesertedCarts();
	List<DesertedCartDetailReportDTO> findDesertedCartDetail(Long orderId);
}
