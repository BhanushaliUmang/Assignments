package com.example.hospital.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.SpecialityDao;
import com.example.hospital.model.Speciality;

@Service
public class SpecialityService {

    @Autowired
    SpecialityDao specialityDao;

    public int saveSpeciality(Speciality specialityObj) {
        return specialityDao.save(specialityObj).getId();
    }
}