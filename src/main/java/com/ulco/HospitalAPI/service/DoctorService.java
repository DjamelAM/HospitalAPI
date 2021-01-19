package com.ulco.HospitalAPI.service;


import com.ulco.HospitalAPI.dto.DoctorDTO;
import com.ulco.HospitalAPI.exception.NotFoundException;
import com.ulco.HospitalAPI.mapper.IDoctorMapper;
import com.ulco.HospitalAPI.model.DoctorDO;
import com.ulco.HospitalAPI.repository.IDoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private IDoctorMapper doctorMapper;

    @Autowired
    private IDoctorRepository doctorRepository;

    @Override
    public DoctorDTO findById(final Integer id) {
        return doctorRepository.findById(id)
                .map(doctorMapper::toDoctorDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<DoctorDTO> findAll() {
        return doctorRepository.findAll().stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(final DoctorDTO doctorDTO) {


        final DoctorDO doctorToCreate = doctorMapper.toDoctorDO(doctorDTO);
        final DoctorDO createdDoctor = doctorRepository.save(doctorToCreate);
        return createdDoctor.getId();
    }

    @Override
    public void update(final Integer id, final DoctorDTO DoctorDTO) {

        findById(id);

        DoctorDO DoctorToUpdate = doctorMapper.toDoctorDO(DoctorDTO);
        DoctorToUpdate.setId(id);

        doctorRepository.save(DoctorToUpdate);
    }

    @Override
    public void deleteById(final Integer id) {
        findById(id);
        doctorRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        doctorRepository.deleteAll();
    }



}


