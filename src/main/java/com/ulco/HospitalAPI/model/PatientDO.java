package com.ulco.HospitalAPI.model;

import com.ulco.HospitalAPI.enums.SexeEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient")
public class PatientDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "sexe")
    @Enumerated(EnumType.STRING)
    private SexeEnum sexeEnum;
}
