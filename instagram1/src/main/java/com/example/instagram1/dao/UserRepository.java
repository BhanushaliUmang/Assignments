package com.example.instagram1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.instagram1.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
