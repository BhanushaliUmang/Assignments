package com.example.instagram1.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.instagram1.dao.PostRepository;
import com.example.instagram1.dao.UserRepository;
import com.example.instagram1.model.Post;
import com.example.instagram1.model.User;


@Service
public class PostService {
       @Autowired
       PostRepository repo;
       @Autowired
       UserRepository urepo;

    public void savePost(String postRequest) {
      JSONObject obj = new JSONObject(postRequest);
      Post post = setPost(obj);
      repo.save(post);
      

    }
    private Post setPost(JSONObject obj) {
        Post p = new Post();
        String id = obj.getString("userid");
        User u = urepo.findById(Integer.valueOf(id)).get();
        p.setUser(u);
         return p;
        
        
    }
    public List<Post> findallpost(Post post) {
        return repo.findAll();
    }
    public Post findvyidpost(int id) {
        return repo.findById(id).get();
    }
    public void deletebyid(int id) {
        Post p = repo.findById(id).get();
        repo.delete(p);
    }
    
}
