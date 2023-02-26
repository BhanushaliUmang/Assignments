package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;
    
    @PostMapping("/poststudent")
    public String poststudent(@RequestBody Student student){
            service.addStudent(student);
            return "Student details saved";
    }

    @DeleteMapping("/delete/Student/{id}")
    public String deleteStudentById(@PathVariable String id){
           service.deleteStudentById(id);
           return "Deleted Sucessfully";
    }

    @GetMapping("/getStudent")
    public List<Student> getAllStudent(){
        return service.getAllStudent();
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @PutMapping("/updatestudent/{id}")
    public String updateStudent(@PathVariable String id , @RequestBody Student student){
          service.updateStudent(id,student);


        return "updated sucessfully";
    }

  


}
