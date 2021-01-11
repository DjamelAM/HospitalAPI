package com.ulco.HospitalAPI.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class StatDTO {

    @NotNull
    Integer nbDoctors;

    @NotNull
    Integer nbPatients;

    @NotNull
    Integer nbServices;

    List<ServiceHospitalizationsDTO> serviceHospitalizations;
}
