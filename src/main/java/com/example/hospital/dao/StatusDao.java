package com.example.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Status;

public interface StatusDao extends JpaRepository<Status,Integer> {
}