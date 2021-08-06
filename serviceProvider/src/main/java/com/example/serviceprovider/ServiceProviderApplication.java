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
            repository.insert(product);

//            repository.find.ifPresentOrElse(
//                    s -> {
//                        System.out.println(s + " already exists");
//                    }, () -> {
//                        System.out.println("Inserting student " + email);
//                        repository.insert(student);
//                    });
        };
    }
}
