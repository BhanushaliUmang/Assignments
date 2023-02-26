package com.example.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Course;
import com.example.student.repo.CourseRepo;

@Service
public class CourseService {
    @Autowired
    CourseRepo repo;

    public void addcourse(Course course) {
      
        
        String Id = UUID.randomUUID().toString();
        Course newcourse = new Course();
        newcourse.setCourseID(Id);
        newcourse.setDescription(course.getDescription());
        newcourse.setDuration(course.getDuration());
        newcourse.setTitle(course.getTitle());

        

        
        repo.save(newcourse);
    }

    public void deleteCourseById(String id) {
        repo.deleteById(id);
    }

    public List<Course> getAllcourse() {
        return repo.findAll();
    }

    public Course getCourseById(String id) {
        return repo.findById(id).get();
    }

    public void updatecourse(String id, Course course) {
        Course newcourse = repo.findById(id).get();
        newcourse.setDescription(course.getDescription());
        newcourse.setDuration(course.getDuration());
        newcourse.setTitle(course.getTitle());
        repo.save(newcourse);


    }
}
