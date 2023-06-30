package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}