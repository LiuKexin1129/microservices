package com.example.serviceprovider.controller;

import com.example.serviceprovider.Product;
import com.example.serviceprovider.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> fetchAllProducts() {
        Product product = new Product
                ("Ha",
                 12,
                 1212
                );
        List<Product> allProducts = productService.getAllProducts();
        allProducts.add(product);
        return allProducts;
    }

}
