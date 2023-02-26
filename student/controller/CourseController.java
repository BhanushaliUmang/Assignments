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

import com.example.student.model.Course;
import com.example.student.service.CourseService;

@RestController
public class CourseController {
    @Autowired
    private CourseService service;
    @PostMapping("/postcourse")
    public String postcourse(@RequestBody Course course){
            service.addcourse(course);
            return "Course details saved";
    }

    @DeleteMapping("/delete/Course/{id}")
    public String deleteCourseById(@PathVariable String id){
           service.deleteCourseById(id);
           return "Deleted Sucessfully";
    }

    @GetMapping("/getCourse")
    public List<Course> getAllCourse(){
        return service.getAllcourse();
    }

    @GetMapping("/getCourse/{id}")
    public Course getCourseById(@PathVariable String id){
        return service.getCourseById(id);
    }

    @PutMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable String id , @RequestBody Course course){
          service.updatecourse(id,course);


        return "updated sucessfully";
    }
}
