package com.techie.microservice.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techie.microservice.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
