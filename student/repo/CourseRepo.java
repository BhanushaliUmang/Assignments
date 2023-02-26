package com.example.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Course;

public interface CourseRepo extends JpaRepository<Course,String> {
    
}
