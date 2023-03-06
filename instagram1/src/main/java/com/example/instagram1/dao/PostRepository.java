package com.example.instagram1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.instagram1.model.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{
    
}
