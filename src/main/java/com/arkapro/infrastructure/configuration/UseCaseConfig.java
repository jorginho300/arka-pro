package com.arkapro.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.arkapro.ports.CategoryRepositoryPort;
import com.arkapro.ports.ProductRepositoryPort;
import com.arkapro.ports.in.CreateProductUseCase;

@Configuration
public class UseCaseConfig {
	
	@Bean
	public CreateProductUseCase createProductUseCase(ProductRepositoryPort productRepository, CategoryRepositoryPort categoryRepository) {
		return new CreateProductUseCase(productRepository, categoryRepository);
	}

}
