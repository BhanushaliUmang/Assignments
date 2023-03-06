package com.example.doctorpatient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctorpatient.model.PatientModel;

public interface PatientRepository extends JpaRepository<PatientModel,Integer>{
    
}
