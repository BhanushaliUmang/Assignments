package com.example.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Symptom;

import java.util.List;

public interface SymptomDao extends JpaRepository<Symptom,Integer> {
    List<Symptom> findBySymptomName(String symptomName);
}