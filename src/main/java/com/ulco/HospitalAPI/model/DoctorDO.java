package com.ulco.HospitalAPI.model;

import com.ulco.HospitalAPI.enums.Sexe;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctor")
public class DoctorDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sexe")
    private Sexe sexe;

    @Column(name = "service_id")
    private Integer serviceId;
}
