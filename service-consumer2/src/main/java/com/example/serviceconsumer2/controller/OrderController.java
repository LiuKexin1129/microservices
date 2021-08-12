package com.example.serviceconsumer2.controller;

import com.example.serviceconsumer2.pojo.Order;
import com.example.serviceconsumer2.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "defaultFallBack")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @HystrixCommand(fallbackMethod = "defaultOrder")
    @GetMapping("/{id}")
    public Order selectOrderById(@PathVariable("id") Integer id) {
        return orderService.selectOrderById(id);
    }

    public Order defaultOrder(Integer id) {
        System.out.println("Hystrix is Ok");
        Order order = new Order(
                id,
                "Do not call again please",
                null,
                null,
                null
        );
        return order;
    }

    public Order defaultFallBack(Integer id){
        System.out.println("Hystrix is Ok");
        Order order = new Order(
                id,
                "Do not call again please",
                null,
                null,
                null
        );
        return order;
    }


}
