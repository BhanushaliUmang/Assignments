package com.example.hospital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.model.Status;
import com.example.hospital.service.StatusService;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    
     @Autowired
    StatusService statusService;

    @PostMapping("/create-status")
    public ResponseEntity<String> createStatus(@RequestBody Status statusData){
        int id = statusService.saveStatus(statusData);
        return new ResponseEntity<>("status saved - "+id, HttpStatus.CREATED);
    }
}
