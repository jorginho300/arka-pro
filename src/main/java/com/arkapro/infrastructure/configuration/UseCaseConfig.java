package com.arkapro.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.arkapro.ports.CategoryRepositoryPort;
import com.arkapro.ports.ProductRepositoryPort;
import com.arkapro.ports.StockManagementRepositoryPort;
import com.arkapro.ports.in.CreateProductUseCase;
import com.arkapro.ports.in.StockAdditionConfirmationUseCase;
import com.arkapro.ports.in.StockAdditionDemandUseCase;

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

}
