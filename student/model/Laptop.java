package com.example.student.model;

import jakarta.persistence.CascadeType;

// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {
    @Id
    private String LaptopID;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    private Student student;
}
