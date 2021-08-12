package com.example.serviceconsumer2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private String id;
    private String productName;
    private Integer productAmount;
    private Integer productPrice;

}
