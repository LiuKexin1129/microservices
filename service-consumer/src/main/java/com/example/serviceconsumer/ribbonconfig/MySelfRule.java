package com.example.serviceconsumer.ribbonconfig;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MySelfRule {
    @Bean
    public IRule getIRule() {
        return new MyRule();
    }
}