package com.ulco.HospitalAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalizationDTO {

    Integer id;

    @NotNull
    Integer serviceId;

    @NotNull
    Integer doctorId;

    @NotNull
    Integer patientId;

    @NotBlank
    Date startDate;

    @NotBlank
    Date endDate;


}
