package com.example.student.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;

@Service
public class StudentService {
     @Autowired
     StudentRepo repo;
     public void addStudent(Student student){
        String Id = UUID.randomUUID().toString();
        Student newStudent = new Student();
        newStudent.setStudentID(Id);
        newStudent.setAddress(student.getAddress());
        newStudent.setAge(student.getAge());
        newStudent.setBranch(student.getBranch());
        newStudent.setDepartment(student.getDepartment());
        newStudent.setName(student.getName());
        newStudent.setPhoneNumber(student.getPhoneNumber());
        repo.save(newStudent);
     }
    public void deleteStudentById(String id) {
        repo.deleteById(id);
    }
    public List<Student> getAllStudent() {
        return repo.findAll();
    }
    public Student getStudentById(String id) {
        return repo.findById(id).get();
    }
    public void updateStudent(String id,Student student){
              Student newStudent = repo.findById(id).get();
              newStudent.setAddress(student.getAddress());
              newStudent.setAge(student.getAge());
              newStudent.setBranch(student.getBranch());
              newStudent.setDepartment(student.getDepartment());
              newStudent.setName(student.getName());
              newStudent.setPhoneNumber(student.getPhoneNumber());
              repo.save(newStudent);
             
    }
}
