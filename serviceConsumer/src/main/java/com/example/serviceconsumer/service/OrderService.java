package com.example.serviceconsumer.service;

import com.example.serviceconsumer.pojo.Order;

public interface OrderService {
    Order selectOrderById(Integer Id);
}


