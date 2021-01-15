package com.ulco.HospitalAPI.service;

import com.ulco.HospitalAPI.dto.ServiceDTO;

import java.util.List;

public interface IServiceService {
    List<ServiceDTO> findAll();

    ServiceDTO findById(Integer id);

    Integer save(ServiceDTO ServiceDTO);

    void update(Integer id, ServiceDTO updatedServiceDTO);

    void deleteAll();

    void deleteById(Integer id);
}
