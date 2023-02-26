package com.example.student.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Laptop;
import com.example.student.model.Student;
import com.example.student.repo.LaptopRepo;
@Service
public class LaptopService {
    @Autowired
    LaptopRepo repo;
    @Autowired
    StudentService ser;

    public void addLaptop(Laptop laptop) {
    //     Student s = ser.getStudentById(laptop.getStudent().getStudentID());
    //     String Id = UUID.randomUUID().toString();
    //    Laptop newlaptop = new Laptop();
    //     newlaptop.setLaptopID(Id);
    //     // newlaptop.setAddress(student.getAddress());
    //     newlaptop.setStudent(s);
    //     newlaptop.setBrand(laptop.getBrand());
    //     newlaptop.setName(laptop.getName());
    //     newlaptop.setPrice(laptop.getPrice());

       
        repo.save(laptop);
    }

    public void deleteLaptopById(String id) {
        repo.deleteById(id);
    }

    public List<Laptop> getAlllaptop() {
        return repo.findAll();
    }

    public Laptop getLaptopById(String id) {
        return repo.findById(id).get();
    }

    public void updateLaptop(String id,Laptop laptop){
        Laptop newlaptop= repo.findById(id).get();
         newlaptop.setBrand(laptop.getBrand());
         newlaptop.setName(laptop.getName());
          newlaptop.setPrice(laptop.getPrice());
          repo.save(newlaptop);
      
       
}
    
}
