package com.example.serviceprovider.repository;

import com.example.serviceprovider.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
