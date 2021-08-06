package com.example.serviceprovider;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {
    @Id
    private String id;
    private String productName;
    private Integer productAmount;
    private Integer productPrice;

    public Product(String productName, Integer productAmount, Integer productPrice) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
    }
}
