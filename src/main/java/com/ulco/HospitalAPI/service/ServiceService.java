package com.ulco.HospitalAPI.service;


import com.ulco.HospitalAPI.dto.ServiceDTO;
import com.ulco.HospitalAPI.exception.NotFoundException;
import com.ulco.HospitalAPI.mapper.IServiceMapper;
import com.ulco.HospitalAPI.model.ServiceDO;
import com.ulco.HospitalAPI.repository.IServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceMapper serviceMapper;

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public ServiceDTO findById(final Integer id) {
        return serviceRepository.findById(id)
                .map(serviceMapper::toServiceDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ServiceDTO> findAll() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toServiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(final ServiceDTO serviceDTO) {


        final ServiceDO serviceToCreate = serviceMapper.toServiceDO(serviceDTO);
        final ServiceDO createdservice = serviceRepository.save(serviceToCreate);
        return createdservice.getId();
    }

    @Override
    public void update(final Integer id, final ServiceDTO serviceDTO) {

        findById(id);

        ServiceDO serviceToUpdate = serviceMapper.toServiceDO(serviceDTO);
        serviceToUpdate.setId(id);

        serviceRepository.save(serviceToUpdate);
    }

    @Override
    public void deleteById(final Integer id) {
        findById(id);
        serviceRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        serviceRepository.deleteAll();
    }



}


