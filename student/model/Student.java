package com.example.student.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;

// import javax.persistence.Embedded;
// import javax.persistence.Entity;
// import javax.persistence.Id;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {
    
    @Id
    private String StudentID;
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;
    
    @Embedded
    private Address address;


    // @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    // private List<Book> books = new ArrayList<>();

    // @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    // private List<Course> courses = new ArrayList<>();
    

}
