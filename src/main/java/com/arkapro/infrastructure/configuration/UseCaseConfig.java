package com.arkapro.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arkapro.ports.in.AddItemsPurchaseOrderUseCase;
import com.arkapro.ports.in.ConfirmPurchaseOrderUseCase;
import com.arkapro.ports.in.CreateProductUseCase;
import com.arkapro.ports.in.CreatePurchaseOrderUseCase;
import com.arkapro.ports.in.DesertPurchaseOrderUseCase;
import com.arkapro.ports.in.RemoveItemsPurchaseOrderUseCase;
import com.arkapro.ports.in.StockAdditionConfirmationUseCase;
import com.arkapro.ports.in.StockAdditionDemandUseCase;
import com.arkapro.ports.repository.CategoryRepositoryPort;
import com.arkapro.ports.repository.CustomerRepositoryPort;
import com.arkapro.ports.repository.ProductRepositoryPort;
import com.arkapro.ports.repository.PurchaseOrderRepositoryPort;
import com.arkapro.ports.repository.StockManagementRepositoryPort;

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

}
