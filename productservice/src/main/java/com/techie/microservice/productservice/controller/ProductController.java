package com.techie.microservice.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techie.microservice.productservice.dto.ProductRequest;
import com.techie.microservice.productservice.dto.ProductResponse;
import com.techie.microservice.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductRequest createProduct(@RequestBody ProductRequest productRequest) {
		return productService.createProduct(productRequest);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getProducts() {
		return productService.getAllProducts();
	}

}
