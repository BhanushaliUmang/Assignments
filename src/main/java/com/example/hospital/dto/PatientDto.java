package com.example.hospital.dto;

import lombok.Data;

@Data
public class PatientDto {
    private String name;
    private String city;
    private String email;
    private String phone_number;
    private String symptom;
}