package com.arkapro.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arkapro.core.ports.in.AddItemsPurchaseOrderUseCase;
import com.arkapro.core.ports.in.ConfirmPurchaseOrderUseCase;
import com.arkapro.core.ports.in.CreateProductUseCase;
import com.arkapro.core.ports.in.CreatePurchaseOrderUseCase;
import com.arkapro.core.ports.in.DesertPurchaseOrderUseCase;
import com.arkapro.core.ports.in.GenerateDesertedCartsDetailReportUseCase;
import com.arkapro.core.ports.in.GenerateDesertedCartsReportUseCase;
import com.arkapro.core.ports.in.GenerateFrequentCustomersReportUseCase;
import com.arkapro.core.ports.in.GenerateLowStockReportUseCase;
import com.arkapro.core.ports.in.GenerateTopSalesReportUseCase;
import com.arkapro.core.ports.in.RemoveItemsPurchaseOrderUseCase;
import com.arkapro.core.ports.in.StockAdditionConfirmationUseCase;
import com.arkapro.core.ports.in.StockAdditionDemandUseCase;
import com.arkapro.core.ports.query.ReportQueryPort;
import com.arkapro.core.ports.repository.CategoryRepositoryPort;
import com.arkapro.core.ports.repository.CustomerRepositoryPort;
import com.arkapro.core.ports.repository.ProductRepositoryPort;
import com.arkapro.core.ports.repository.PurchaseOrderRepositoryPort;
import com.arkapro.core.ports.repository.StockManagementRepositoryPort;

@Configuration
public class UseCaseConfig {
	
	@Bean
	public CreateProductUseCase createProductUseCase(ProductRepositoryPort productRepository, CategoryRepositoryPort categoryRepository) {
		return new CreateProductUseCase(productRepository, categoryRepository);
	}
	
	@Bean
	public StockAdditionConfirmationUseCase stockAdditionConfirmationUseCase
	(ProductRepositoryPort productRepository, StockManagementRepositoryPort stockRepository) {
		return new StockAdditionConfirmationUseCase(productRepository, stockRepository);
	}
	
	@Bean
	public StockAdditionDemandUseCase stockDemandUseCase(StockManagementRepositoryPort stockRepository) {
		return new StockAdditionDemandUseCase(stockRepository);
	}
	
	@Bean
	public ConfirmPurchaseOrderUseCase confirmPurchaseOrderUseCase
	(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		return new ConfirmPurchaseOrderUseCase(purchaseOrderRepository, productRepository);
	}
	
	@Bean
	public CreatePurchaseOrderUseCase createPurchaseOrderUseCase
	(PurchaseOrderRepositoryPort purchaseOrderRepository, 
			CustomerRepositoryPort customerRepository, 
			ProductRepositoryPort productRepository) {
		return new CreatePurchaseOrderUseCase(purchaseOrderRepository, customerRepository, productRepository);
	}
	
	@Bean
	public DesertPurchaseOrderUseCase desertPurchaseOrderUseCase
	(PurchaseOrderRepositoryPort orderRepository, ProductRepositoryPort productRepository) {
		return new DesertPurchaseOrderUseCase(orderRepository, productRepository);
	}
	
	@Bean
	public AddItemsPurchaseOrderUseCase addItemsPurchaseOrderUseCase
	(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		return new AddItemsPurchaseOrderUseCase(purchaseOrderRepository, productRepository);
	}
	
	@Bean
	public RemoveItemsPurchaseOrderUseCase removeItemsPurchaseOrderUseCase
	(PurchaseOrderRepositoryPort purchaseOrderRepository, ProductRepositoryPort productRepository) {
		return new RemoveItemsPurchaseOrderUseCase(purchaseOrderRepository, productRepository);
	}
	
	@Bean
	public GenerateLowStockReportUseCase generateLowStockReportUseCase(ReportQueryPort reportQuery) {
		return new GenerateLowStockReportUseCase(reportQuery);
	}
	
	@Bean
	public GenerateTopSalesReportUseCase generateTopSalesReportUseCase(ReportQueryPort reportQuery) {
		return new GenerateTopSalesReportUseCase(reportQuery);
	}
	
	@Bean
	public GenerateFrequentCustomersReportUseCase generateFrequentCustomersReportUseCase(ReportQueryPort reportQuery) {
		return new GenerateFrequentCustomersReportUseCase(reportQuery);
	}
	
	@Bean
	public GenerateDesertedCartsReportUseCase generateDesertedCartsReportUseCase(ReportQueryPort reportQuery) {
		return new GenerateDesertedCartsReportUseCase(reportQuery);
	}
	
	@Bean
	public GenerateDesertedCartsDetailReportUseCase generateDesertedCartsDetailReportUseCase(ReportQueryPort reportQuery) {
		return new GenerateDesertedCartsDetailReportUseCase(reportQuery);
	}

}
