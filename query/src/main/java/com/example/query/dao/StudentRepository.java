package com.example.query.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.query.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student_tbl where active=true", nativeQuery = true)
    public List<Student> findByActive();

    @Query(value = "select * from student_tbl where firstName = :firstName", nativeQuery = true)
    public List<Student> findByfirstname(String firstName);

    @Query(value = "select * from student_tbl where lastName = :lastName", nativeQuery = true)
    public List<Student> findBylastname(String lastName);

    @Query(value = "select * from student_tbl where age = :age", nativeQuery = true)
    public List<Student> findByAge(Integer age);
}
