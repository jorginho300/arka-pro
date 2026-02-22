package com.arkapro.core.ports.in;

import com.arkapro.core.ports.repository.CategoryRepositoryPort;
import com.arkapro.core.ports.repository.ProductRepositoryPort;
import com.arkapro.domain.model.Category;
import com.arkapro.domain.model.Product;
import com.arkapro.infrastructure.adapter.in.dto.request.CreateProductCommandRequest;

public class CreateProductUseCase {
	private final ProductRepositoryPort productRepository;
	private final CategoryRepositoryPort categoryRepository;
	
	public CreateProductUseCase(ProductRepositoryPort productRepository, CategoryRepositoryPort categoryRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public Product execute(CreateProductCommandRequest request) {
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("Category not found!!"));
		
		Product product = new Product();
		product.setStock(0);
		product.setReservedStock(0);
		product.setName(request.getName());
		product.setCategory(category);
		product.setPrice(request.getPrice());
		product.setDescription(request.getDescription());
		
		return productRepository.save(product);
	}
}
