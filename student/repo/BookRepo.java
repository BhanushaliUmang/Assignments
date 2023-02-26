package com.example.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Book;

public interface BookRepo extends JpaRepository<Book,String>{
    
}
