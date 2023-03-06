package com.example.doctorpatient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctorpatient.model.DoctorModel;

public interface DoctorRepository extends JpaRepository<DoctorModel,Integer>{
    
}
