package com.techie.microservice.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techie.microservice.productservice.dto.ProductRequest;
import com.techie.microservice.productservice.dto.ProductResponse;
import com.techie.microservice.productservice.model.Product;
import com.techie.microservice.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	@Autowired
	private final ProductRepository productRepository;

	public ProductRequest createProduct(ProductRequest productRequest) {
		Product product = Product.builder().name(productRequest.name()).description(productRequest.description())
				.price(productRequest.price()).build();
		productRepository.save(product);
		log.info("Product successfully added to the DB");
		return new ProductRequest(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	public List<ProductResponse> getAllProducts() {
		return productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(),
				product.getName(), product.getDescription(), product.getPrice())).toList();
	}
}
