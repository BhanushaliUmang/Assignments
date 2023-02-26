package com.example.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop,String> {
    
}
