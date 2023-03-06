package com.example.instagram1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.instagram1.model.Post;
import com.example.instagram1.service.PostService;



@RestController
public class PostController {
    @Autowired
    PostService service;
    @PostMapping("/post")
    public ResponseEntity<String> savePost(@RequestBody String postRequest) {
        service.savePost(postRequest);
        return new ResponseEntity<>("Post saved", HttpStatus.OK);
    }
    @GetMapping("/findAllPost")
    public List<Post> postfindall(@RequestBody Post post){
       return  service.findallpost(post);
    }
    @GetMapping("/findPostbyid/{id}")
    public Post findpostbyid(@PathVariable int id){
        return service.findvyidpost(id);
    }
    @DeleteMapping("/deletePostbyid/{id}")
    public String deletepost(@PathVariable int id){
        service.deletebyid(id);
        return"Deleted-post";
    }
}