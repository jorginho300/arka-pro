package com.arkapro.ports.in;

import com.arkapro.domain.model.Category;
import com.arkapro.domain.model.Product;
import com.arkapro.infrastructure.adapter.in.dto.request.CreateProductCommandRequest;
import com.arkapro.ports.CategoryRepositoryPort;
import com.arkapro.ports.ProductRepositoryPort;

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
