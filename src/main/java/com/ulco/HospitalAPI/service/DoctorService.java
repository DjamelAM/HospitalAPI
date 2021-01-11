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
    private IDoctorMapper DoctorMapper;

    @Autowired
    private IDoctorRepository DoctorRepository;

    @Override
    public DoctorDTO findById(final Integer id) {
        return DoctorRepository.findById(id)
                .map(DoctorMapper::toDoctorDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<DoctorDTO> findAll() {
        return DoctorRepository.findAll().stream()
                .map(DoctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(final DoctorDTO DoctorDTO) {


        final DoctorDO DoctorToCreate = DoctorMapper.toDoctorDO(DoctorDTO);
        final DoctorDO createdDoctor = DoctorRepository.save(DoctorToCreate);
        return createdDoctor.getId();
    }

    @Override
    public void update(final Integer id, final DoctorDTO DoctorDTO) {

        findById(id);

        DoctorDO DoctorToUpdate = DoctorMapper.toDoctorDO(DoctorDTO);
        DoctorToUpdate.setId(id);

        DoctorRepository.save(DoctorToUpdate);
    }

    @Override
    public void deleteById(final Integer id) {
        findById(id);
        DoctorRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        DoctorRepository.deleteAll();
    }



}


