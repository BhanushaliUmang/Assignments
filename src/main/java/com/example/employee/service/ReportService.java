package com.example.employee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee.model.Report;
import com.example.employee.repository.ReportRepository;

@Service
public class ReportService {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportRepository reportRepository;
    public ResponseEntity<String> addReport(Report report) {
        Long employeeId = report.getEmployee().getId();
        report.setEmployee(employeeService.getEmployeeById(employeeId));
        reportRepository.save(report);
        return ResponseEntity.ok("Report added for employee with ID: " + employeeId + " on date: " + report.getDate());
    }
}