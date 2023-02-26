package com.example.student.controller;

import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Laptop;
import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;
import com.example.student.service.LaptopService;

@RestController
public class LaptopController {
    

    @Autowired
    private LaptopService service;
    @Autowired
    private StudentRepo stu1;

    @PostMapping("/postlaptop")
    public String postlaptop(@RequestBody String laptop){
        JSONObject json = new JSONObject(laptop);
        Laptop lap = setLaptop(json);
            service.addLaptop(lap);
            return "Laptop details saved";
    }

    private Laptop setLaptop(JSONObject json) {
        Laptop l = new Laptop();
        l.setBrand(json.getString("brand"));
        String Id = UUID.randomUUID().toString();
        l.setLaptopID(Id);
        l.setName(json.getString("name"));
        l.setPrice(json.getInt("price"));

        String stuid = json.getString("studentid");

        l.setStudent(stu1.findById(stuid).get());
         return l;
        
        
    }
        

    @DeleteMapping("/delete/Laptop/{id}")
    public String deleteLaptopById(@PathVariable String id){
           service.deleteLaptopById(id);
           return "Deleted Sucessfully";
    }

    @GetMapping("/getLaptop")
    public List<Laptop> getAllLaptop(){
        return service.getAlllaptop();
    }

    @GetMapping("/getLaptop/{id}")
    public Laptop getLaptopById(@PathVariable String id){
        return service.getLaptopById(id);
    }

    @PutMapping("/updateLaptop/{id}")
    public String updateLaptop(@PathVariable String id , @RequestBody Laptop laptop){
          service.updateLaptop(id,laptop);


        return "updated sucessfully";
    }
}
