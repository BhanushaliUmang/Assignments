package com.example.usermanage.usermodel;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "Username can't be null")
    @Size(min = 3, max = 20, message = "You need to write username between 3 to 20 character")
    private String userName;

    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = " DOB : Date of birth must be in the format DD-MM-YYYY.")
    private String dateOfBirth;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email address.")
    private String mail;
    
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Phone number must be 12 digits long , First two digits are country code")
    private String phoneNumber;

    private LocalDate date;
    private LocalTime time;
}
