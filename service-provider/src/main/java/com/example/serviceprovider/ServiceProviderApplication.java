package com.example.serviceprovider;

import com.example.serviceprovider.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return args -> {
            Product product = new Product(
                    "iPhone",
                    1,
                    9999
            );

            Product product1 = new Product(
                    "Airpods",
                    2,
                    1111
            );
            Product product2 = new Product(
                    "Macbook",
                    1,
                    12222
            );
            Product product3 = new Product(
                    "iPad",
                    2,
                    8888
            );

            repository.insert(product);
            repository.insert(product1);
            repository.insert(product2);
            repository.insert(product3);
        };
    }
}
