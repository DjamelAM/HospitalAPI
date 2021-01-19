package com.ulco.HospitalAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalizationDTO {


    @NotNull
    private Integer serviceId;

    @NotNull
    private Integer doctorId;

    @NotNull
    private Integer patientId;

    @NotBlank
    private Date startDate;

    @NotBlank
    private Date endDate;


}
