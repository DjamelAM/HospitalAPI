package com.ulco.HospitalAPI.dto;

import com.ulco.HospitalAPI.enums.SexeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    String firstname;
    String lastname;
    SexeEnum sexeEnum;
}
