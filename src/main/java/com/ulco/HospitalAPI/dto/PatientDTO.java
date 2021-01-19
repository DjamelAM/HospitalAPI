package com.ulco.HospitalAPI.dto;

import com.ulco.HospitalAPI.enums.SexeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    @NotBlank
    String firstname;

    @NotBlank
    String lastname;

    @NotBlank
    SexeEnum sexeEnum;
}
