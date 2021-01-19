package com.ulco.HospitalAPI.service;


import com.ulco.HospitalAPI.dto.PatientDTO;
import com.ulco.HospitalAPI.exception.NotFoundException;
import com.ulco.HospitalAPI.mapper.IPatientMapper;
import com.ulco.HospitalAPI.model.PatientDO;
import com.ulco.HospitalAPI.repository.IPatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientMapper patientMapper;

    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public PatientDTO findById(final Integer id) {
        return patientRepository.findById(id)
                .map(patientMapper::toPatientDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<PatientDTO> findAll() {
        return patientRepository.findAll().stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(final PatientDTO patientDTO) {


        final PatientDO patientToCreate = patientMapper.toPatientDO(patientDTO);
        final PatientDO createdpatient = patientRepository.save(patientToCreate);
        return createdpatient.getId();
    }

    @Override
    public void update(final Integer id, final PatientDTO patientDTO) {

        findById(id);

        PatientDO patientToUpdate = patientMapper.toPatientDO(patientDTO);
        patientToUpdate.setId(id);

        patientRepository.save(patientToUpdate);
    }

    @Override
    public void deleteById(final Integer id) {
        findById(id);
        patientRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        patientRepository.deleteAll();
    }



}


