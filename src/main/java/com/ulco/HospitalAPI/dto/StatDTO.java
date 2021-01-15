package com.ulco.HospitalAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatDTO {

    @NotNull
    private Integer nbDoctors;

    @NotNull
    private Integer nbPatients;

    @NotNull
    private Integer nbServices;

    @NotNull
    private List<ServiceHospitalizationsDTO> serviceHospitalizations;

}
