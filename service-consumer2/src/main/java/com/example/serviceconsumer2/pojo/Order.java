package com.example.serviceconsumer2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Integer id;
    private String orderNo;
    private String orderAddress;
    private Integer totalPrice;
    private List<Product> productList;
}
