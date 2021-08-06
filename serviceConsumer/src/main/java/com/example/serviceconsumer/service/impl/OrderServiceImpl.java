package com.example.serviceconsumer.service.impl;

import com.example.serviceconsumer.pojo.Order;
import com.example.serviceconsumer.pojo.Product;
import com.example.serviceconsumer.service.OrderService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Override
    public Order selectOrderById(String id) {
        return new Order(id, "order-001", "China", 31994,
                selectProductListByDiscoveryClient());
    }

    private List<Product> selectProductListByDiscoveryClient() {
        StringBuffer sb = null;

        List<String> serviceIds = discoveryClient.getServices();
        if(CollectionUtils.isEmpty(serviceIds) ) {
            return null;
        }

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("serviceProvider");
        if(CollectionUtils.isEmpty(serviceInstances) ) {
            return null;
        }

        ServiceInstance si = serviceInstances.get(0);
        sb = new StringBuffer();
        sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");
        System.out.println(sb.toString());

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getBody();
    }

    private List<Product> selectProductByLoadBalancerClient() {
        StringBuffer sb = null;

        ServiceInstance si = loadBalancerClient.choose("serviceProvider");
        if(null == si)
            return null;

        sb = new StringBuffer();
        sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");

        ResponseEntity<List<Product>> response = restTemplate.exchange(
                sb.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
        );
        return response.getBody();

    }

    private List<Product> selectProductListByLoadBalancerAnnotation() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://serviceProvider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){}
        );
        return response.getBody();
    }


}
