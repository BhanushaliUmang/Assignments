package com.example.employee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class AdminService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<String> createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee Details Successfully");
    }
}