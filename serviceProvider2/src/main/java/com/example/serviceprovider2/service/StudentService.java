package com.example.serviceprovider2.service;

import com.example.serviceprovider2.Repository.StudentRepository;
import com.example.serviceprovider2.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.insert(student);
        System.out.println(student);
    }

    public void deleteStudent(String id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);
    }


    @Transactional
    public void updateStudent(String id,
                              String name,
                              String email) {
        Student s = studentRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException(
                                "student with id " + id + " does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(s.getName(), name)) {
            s.setName(name);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(s.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            s.setEmail(email);
        }

        studentRepository.save(s);
    }

}
