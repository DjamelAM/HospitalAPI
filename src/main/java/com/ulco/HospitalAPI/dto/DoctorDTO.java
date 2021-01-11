package com.ulco.HospitalAPI.dto;

import com.ulco.HospitalAPI.enums.Sexe;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    @NotBlank
    private Sexe sexe;

    @NotNull
    private Integer serviceId;

}
