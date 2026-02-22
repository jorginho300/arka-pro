package com.arkapro.infrastructure.adapter.in.rest.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arkapro.core.ports.in.CreateProductUseCase;
import com.arkapro.domain.model.Product;
import com.arkapro.infrastructure.adapter.in.dto.request.CreateProductCommandRequest;

@RestController
@RequestMapping("/apiarkav2/products")
public class ProductController {
	private final CreateProductUseCase useCase;
	
	public ProductController(CreateProductUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CreateProductCommandRequest request) {
		Product product = useCase.execute(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}

}
