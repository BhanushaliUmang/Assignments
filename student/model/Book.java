package com.example.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private String ID;

    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
