package com.example.serviceconsumer2.service;

import com.example.serviceconsumer2.pojo.Order;

public interface OrderService {
    Order selectOrderById(Integer Id);
}
