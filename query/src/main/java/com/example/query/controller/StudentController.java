package com.example.query.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.query.model.Student;
import com.example.query.service.StudentService;



@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/addstudent")
    public ResponseEntity<String> postStudent(@RequestBody String s) {
        JSONObject json = new JSONObject(s);
        Student student = setStudent(json);
        service.saveStudent(student);
        return new ResponseEntity<>("student details saved", HttpStatus.CREATED);

    }

    public Student setStudent(JSONObject obj) {
        Student s1 = new Student();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        s1.setFirstName(obj.getString("firstname"));
        s1.setLastName(obj.getString("lastname"));
        s1.setAge(obj.getInt("age"));
        s1.setActive(obj.getBoolean("active"));

        s1.setAdmissionDate(date);

        return s1;

    }

    @GetMapping("/getstudents")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> s = service.getStudents();
        return new ResponseEntity<>(s, HttpStatus.OK);

    }

    @GetMapping("/getbyfirstname/{firstName}")
    public ResponseEntity<List<Student>> getfirstname(@PathVariable String firstName) {
        List<Student> s = service.getbyfirstname(firstName);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("/getbyLastName/{lastName}")
    public ResponseEntity<List<Student>> getStudentsByLastName(@PathVariable String lastName) {
        List<Student> list = service.getByLastName(lastName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/byAge/{age}")
    public ResponseEntity<List<Student>> getStudentsByAge(@PathVariable Integer age) {
        List<Student> list = service.getByAge(age);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
