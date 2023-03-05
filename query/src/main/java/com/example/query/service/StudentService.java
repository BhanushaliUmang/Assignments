package com.example.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.query.dao.StudentRepository;
import com.example.query.model.Student;



@Service
public class StudentService {

    @Autowired
    StudentRepository studentrepo;

    public void saveStudent(Student student) {
        studentrepo.save(student);
    }

    public List<Student> getStudents() {
        return studentrepo.findByActive();
    }

    public List<Student> getbyfirstname(String firstName) {
        return studentrepo.findByfirstname(firstName);
    }

    public List<Student> getByLastName(String lastName) {
        return studentrepo.findBylastname(lastName);
    }

    public List<Student> getByAge(Integer age) {
        return studentrepo.findByAge(age);
    }

}
