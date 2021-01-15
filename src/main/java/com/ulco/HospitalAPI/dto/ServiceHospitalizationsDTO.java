package com.ulco.HospitalAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceHospitalizationsDTO {

    @NotBlank
    private String serviceName;

    @NotBlank
    private Integer nbHospitalizations;


}
