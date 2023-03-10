package com.example.chatapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatapplication.dao.StatusRepository;
import com.example.chatapplication.model.Status;


@Service
public class StatusService {

    @Autowired
    StatusRepository repository;

    public int saveStatus(Status status) {
        Status statusObj = repository.save(status);
        return statusObj.getStatusId();
    }
    
}
