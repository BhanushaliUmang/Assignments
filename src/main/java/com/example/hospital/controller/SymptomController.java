package com.example.hospital.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.dao.SpecialityDao;
import com.example.hospital.dto.SymptomDto;
import com.example.hospital.model.Speciality;
import com.example.hospital.model.Symptom;
import com.example.hospital.service.SymptomService;

@RestController
@RequestMapping(value = "/api/v1/symptom")
public class SymptomController {
    
     @Autowired
    SymptomService symptomService;

    @Autowired
    SpecialityDao specialityDao;

    @PostMapping("/addSymptom")
    public ResponseEntity<String> addSymptom(@RequestBody SymptomDto symptomDto) {
        Symptom symptom = setSymptom(symptomDto);
        int id = symptomService.addSymptom(symptom);
        return new ResponseEntity<>("Symptom saved with id - "+id, HttpStatus.OK);
    }

    private Symptom setSymptom(SymptomDto symptomDto) {
        Symptom symptom = new Symptom();
        JSONObject jsonObject = new JSONObject(symptomDto);
        if (jsonObject.has("symptom")) {
            symptom.setSymptomName(jsonObject.get("symptom").toString());
        }
        if (jsonObject.has("speciality")) {
            Speciality speciality = specialityDao.findBySpecialityName(jsonObject.getString("speciality"));
            symptom.setSpeciality(speciality);
        }
        return symptom;
    }
}
