package com.ulco.HospitalAPI.service;

import com.ulco.HospitalAPI.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService {


    List<DoctorDTO> findAll();

    DoctorDTO findById(Integer id);

    Integer save(DoctorDTO DoctorDTO);

    void update(Integer id, DoctorDTO updatedDoctorDTO);

    void deleteAll();

    void deleteById(Integer id);
}
