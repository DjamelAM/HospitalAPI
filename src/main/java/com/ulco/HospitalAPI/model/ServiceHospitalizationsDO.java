package com.ulco.HospitalAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "service_hospitalizations")
public class ServiceHospitalizationsDO {

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "nb_hospitalizations")
    private Integer nbHospitalizations;

}
