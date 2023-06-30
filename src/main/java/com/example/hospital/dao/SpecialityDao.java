package com.example.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Speciality;

public interface SpecialityDao extends JpaRepository<Speciality,Integer> {

    Speciality findBySpecialityName(String speciality);
}