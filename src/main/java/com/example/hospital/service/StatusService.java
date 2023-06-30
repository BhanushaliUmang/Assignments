package com.example.hospital.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.StatusDao;
import com.example.hospital.model.Status;

@Service
public class StatusService {

    @Autowired
    StatusDao statusDao;

    public int saveStatus(Status statusData) {
        return statusDao.save(statusData).getStatusId();
    }
}