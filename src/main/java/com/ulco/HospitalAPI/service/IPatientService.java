package com.ulco.HospitalAPI.service;

import com.ulco.HospitalAPI.dto.PatientDTO;

import java.util.List;

public interface IPatientService {
    List<PatientDTO> findAll();

    PatientDTO findById(Integer id);

    Integer save(PatientDTO PatientDTO);

    void update(Integer id, PatientDTO updatedPatientDTO);

    void deleteAll();

    void deleteById(Integer id);
}
