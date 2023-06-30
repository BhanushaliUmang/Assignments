package com.example.hospital.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.SymptomDao;
import com.example.hospital.model.Symptom;

@Service
public class SymptomService {

    @Autowired
    SymptomDao symptomDao;

    public int addSymptom(Symptom symptom) {
        return symptomDao.save(symptom).getId();
    }
}