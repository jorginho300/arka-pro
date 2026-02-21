package com.arkapro.infrastructure.adapter.out.assembler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.arkapro.domain.model.Customer;
import com.arkapro.domain.model.Product;
import com.arkapro.domain.model.PurchaseOrder;
import com.arkapro.infrastructure.adapter.in.dto.response.PurchaseOrderDetailResponse;
import com.arkapro.infrastructure.adapter.in.dto.response.PurchaseOrderResponse;
import com.arkapro.ports.repository.CustomerRepositoryPort;
import com.arkapro.ports.repository.ProductRepositoryPort;

@Component
public class PurchaseOrderResponseAssembler {
	private final CustomerRepositoryPort customerRepository;
	private final ProductRepositoryPort productRepository;
	
	public PurchaseOrderResponseAssembler(CustomerRepositoryPort customerRepository, ProductRepositoryPort productRepository) {
		this.customerRepository = customerRepository;
		this.productRepository = productRepository;
	}
	
	public PurchaseOrderResponse assemble(PurchaseOrder order) {
		String customerName = "Unknown";
		if(order.getCustomer() != null) {
			customerName = customerRepository.findById(order.getCustomer())
					.map(Customer::getName)
					.orElse("Unknown");
		}
		
		List<PurchaseOrderDetailResponse> detailResponses = order.getDetails()
				.stream()
				.map(detail -> {
					String productName = productRepository.findById(detail.getProductId())
							.map(Product::getName)
							.orElse("Unknown");
					
					PurchaseOrderDetailResponse detailResponse = new PurchaseOrderDetailResponse();
					detailResponse.setProductId(detail.getProductId());
					detailResponse.setProductName(productName);
					detailResponse.setQuantity(detail.getQuantity());
					detailResponse.setUnitPrice(detail.getUnitPrice());
					detailResponse.setSubtotal(detail.getSubtotal());
					return detailResponse;
				})
				.toList();
		
		PurchaseOrderResponse response = new PurchaseOrderResponse();
		response.setPurchaseOrderId(order.getId());
		response.setCustomerId(order.getCustomer());
		response.setCustomerName(customerName);
		response.setPurchaseOrderDate(order.getCreatedAt());
		response.setProductsQuantity(order.totalQuantityOfProductsCalculation());
		response.setTotal(order.getTotal());
		response.setDetails(detailResponses);
		return response;
	}
}
