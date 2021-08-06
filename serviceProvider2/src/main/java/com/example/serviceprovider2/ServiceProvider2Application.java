package com.example.serviceprovider2;

import com.example.serviceprovider2.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider2Application.class, args);
    }


    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            String email = "jamila@gmail.com";
            Student student = new Student(
                    "Jamila",
                    "jamila@gmail.com",
                    Gender.FEMALE
            );

            repository.findStudentByEmail(email).ifPresentOrElse(
                    s -> {
                        System.out.println(s + " already exists");
                    }, () -> {
                        System.out.println("Inserting student " + email);
                        repository.insert(student);
                    });
        };
    }
}
