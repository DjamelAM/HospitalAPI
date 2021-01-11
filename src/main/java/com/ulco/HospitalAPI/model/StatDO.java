package com.ulco.HospitalAPI.model;

import com.ulco.HospitalAPI.model.ServiceHospitalizationsDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "stat")
public class StatDO {

    @Column(name = "nb_doctors")
    private Integer nbDoctors;

    @Column(name = "nb_patients")
    private Integer nbPatients;

    @Column(name = "nb_services")
    private Integer nbServices;

    @Column(name = "service_hospitalizations")
    private List<ServiceHospitalizationsDO> serviceHospitalizations;
}
