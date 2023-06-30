package com.example.hospital.service;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.hospital.dao.DoctorDao;
import com.example.hospital.dao.PatientDao;
import com.example.hospital.model.DoctorEntity;
import com.example.hospital.model.PatientEntity;
import com.example.hospital.model.Speciality;
import com.example.hospital.model.Symptom;
import com.example.hospital.utils.CommonUtils;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientDao patientDao;

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    CommonUtils commonUtils;

    public int savePatient(PatientEntity patient) {
        return patientDao.save(patient).getId();
    }

    public ResponseEntity<String> deleteById(Integer id) {
        if(!patientDao.findPatientById(id).isEmpty()){
            patientDao.deletePatientById(id);
            return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid patient_id",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> suggestDoctor(Integer patientId) {
        PatientEntity patient = patientDao.findPatientById(patientId).get(0);
        Symptom symptom = patient.getSymptom();
        Speciality speciality = symptom.getSpeciality();
        String city = patient.getCity();
        int id = speciality.getId();
        if(doctorDao.findDoctorByCity(city).isEmpty()){
            return new ResponseEntity<>("We are still waiting to expand to your location",HttpStatus.NOT_FOUND);
        }else{
            if(doctorDao.findByCityAndSpeciality(city,id).isEmpty()){
                return new ResponseEntity<>("There isn’t any doctor present at your location for your symptom",HttpStatus.NOT_FOUND);
            }else {
                List<DoctorEntity> doctorEntityList = doctorDao.findByCityAndSpeciality(city,id);
                JSONArray jsonArray = new JSONArray();
                for(DoctorEntity doctor:doctorEntityList){
                    JSONObject jsonObject = commonUtils.setJson(doctor);
                    jsonArray.put(jsonObject);
                }
                return new ResponseEntity<>(jsonArray.toString(),HttpStatus.FOUND);
            }
        }
    }


}