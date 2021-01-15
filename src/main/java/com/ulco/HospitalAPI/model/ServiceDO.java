package com.ulco.HospitalAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "service")
public class ServiceDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desctription;

}
