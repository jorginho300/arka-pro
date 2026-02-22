package com.arkapro.infrastructure.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.FrequentCustomerReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.LowStockProductReportDTO;
import com.arkapro.infrastructure.adapter.in.dto.report.TopSellingProductReportDTO;

import jakarta.persistence.EntityManager;

@Repository
public class ReportQueryAdapter implements ReportQueryPort {
	
	private final EntityManager em;
	
	public ReportQueryAdapter(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<LowStockProductReportDTO> findLowStockProducts(Integer threshold) {
		// TODO Auto-generated method stub
		String jpql = """
				SELECT new com.arkapro.infrastructure.adapter.in.dto.report.LowStockProductReportDTO(
				p.id,
				p.name,
				(p.stock - p.reservedStock)
				)
				FROM ProductJpaEntity p
				WHERE (p.stock - p.reservedStock) < :threshold
				""";
		
		return em.createQuery(jpql, LowStockProductReportDTO.class).setParameter("threshold", threshold).getResultList();
	}

	@Override
	public List<TopSellingProductReportDTO> findTopSellingProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FrequentCustomerReportDTO> findFrequentCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DesertedCartReportDTO> findDesertedCarts() {
		// TODO Auto-generated method stub
		return null;
	}

}
