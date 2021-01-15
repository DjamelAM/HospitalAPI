package com.ulco.HospitalAPI.service;

import com.ulco.HospitalAPI.dto.HospitalizationDTO;

import java.util.List;

public interface IHospitalizationService {

    List<HospitalizationDTO> findAll();

    HospitalizationDTO findById(Integer id);

    Integer save(HospitalizationDTO HospitalizationDTO);

    void update(Integer id, HospitalizationDTO updatedHospitalizationDTO);

    void deleteAll();

    void deleteById(Integer id);
}
