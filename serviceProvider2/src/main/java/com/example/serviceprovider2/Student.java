package com.example.serviceprovider2;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private Gender gender;


    public Student(String name,
                   String email,
                   Gender gender) {

        this.name = name;
        this.email = email;
        this.gender = gender;

    }
}
