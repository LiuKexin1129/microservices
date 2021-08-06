package com.example.serviceconsumer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private String id;
    private String orderNo;
    private String orderAddress;
    private Integer totalPrice;
    private List<Product> productList;
}
