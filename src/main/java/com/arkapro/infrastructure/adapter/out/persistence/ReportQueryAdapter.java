package com.arkapro.infrastructure.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartDetailReportDTO;
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
		String jpql = """
				SELECT new com.arkapro.infrastructure.adapter.in.dto.report.TopSellingProductReportDTO(
				d.product.id,
				d.product.name,
				SUM(d.quantity)
				)
				FROM PurchaseOrderDetailJpaEntity d
				JOIN d.purchaseOrder o
				WHERE o.status = 'CONFIRMED'
				GROUP BY d.product.id, d.product.name
				ORDER BY SUM(d.quantity) DESC
				""";
		
		return em.createQuery(jpql, TopSellingProductReportDTO.class).setMaxResults(3).getResultList();
	}

	@Override
	public List<FrequentCustomerReportDTO> findFrequentCustomers() {
		// TODO Auto-generated method stub
		String jpql = """
				SELECT new com.arkapro.infrastructure.adapter.in.dto.report.FrequentCustomerReportDTO(
				o.customer.id,
				o.customer.name,
				COUNT(o.id),
				SUM((SELECT
				 		SUM(d.quantity * d.unitPrice)
				 		FROM PurchaseOrderDetailJpaEntity d
				 		WHERE d.purchaseOrder.id = o.id)
				 		))
				FROM PurchaseOrderJpaEntity o
				WHERE o.status = 'CONFIRMED'
				GROUP BY o.customer.id, o.customer.name
				ORDER BY COUNT(o.id) DESC
				""";
		
		return em.createQuery(jpql, FrequentCustomerReportDTO.class).setMaxResults(5).getResultList();
	}

	@Override
	public List<DesertedCartReportDTO> findDesertedCarts() {
		// TODO Auto-generated method stub
		String jpql = """
				SELECT new com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartReportDTO(
				o.id,
				o.customer.name,
				o.createdAt,
				(
					SELECT SUM(d.quantity * d.unitPrice)
					FROM PurchaseOrderDetailJpaEntity d
					WHERE d.purchaseOrder.id = o.id
				))
				FROM PurchaseOrderJpaEntity o
				WHERE o.status = 'DESERTED'
				ORDER BY o.createdAt DESC
				""";
		
		return em.createQuery(jpql, DesertedCartReportDTO.class).getResultList();
	}

	@Override
	public List<DesertedCartDetailReportDTO> findDesertedCartDetail(Long orderId) {
		// TODO Auto-generated method stub
		String jpql = """
				SELECT new com.arkapro.infrastructure.adapter.in.dto.report.DesertedCartDetailReportDTO(
				d.product.id,
				d.product.name,
				d.quantity,
				d.unitPrice,
				(d.quantity * d.unitPrice))
				FROM PurchaseOrderDetailJpaEntity d
				WHERE d.purchaseOrder.id = :orderId
				""";
		
		return em.createQuery(jpql, DesertedCartDetailReportDTO.class).setParameter("orderId", orderId).getResultList();
	}

}
