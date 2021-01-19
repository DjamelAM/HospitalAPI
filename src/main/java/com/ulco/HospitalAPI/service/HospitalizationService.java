package com.ulco.HospitalAPI.Hospitalization;


import com.ulco.HospitalAPI.dto.HospitalizationDTO;
import com.ulco.HospitalAPI.exception.NotFoundException;
import com.ulco.HospitalAPI.mapper.IHospitalizationMapper;
import com.ulco.HospitalAPI.model.HospitalizationDO;
import com.ulco.HospitalAPI.repository.IHospitalizationRepository;
import com.ulco.HospitalAPI.service.IHospitalizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
public class HospitalizationService implements IHospitalizationService {

    @Autowired
    private IHospitalizationMapper hospitalizationMapper;

    @Autowired
    private IHospitalizationRepository hospitalizationRepository;

    @Override
    public HospitalizationDTO findById(final Integer id) {
        return hospitalizationRepository.findById(id)
                .map(hospitalizationMapper::toHospitalizationDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<HospitalizationDTO> findAll() {
        return hospitalizationRepository.findAll().stream()
                .map(hospitalizationMapper::toHospitalizationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer save(final HospitalizationDTO hospitalizationDTO) {


        final HospitalizationDO hospitalizationToCreate = hospitalizationMapper.toHospitalizationDO(hospitalizationDTO);
        final HospitalizationDO createdHospitalization = hospitalizationRepository.save(hospitalizationToCreate);
        return createdHospitalization.getId();
    }

    @Override
    public void update(final Integer id, final HospitalizationDTO hospitalizationDTO) {

        findById(id);

        HospitalizationDO hospitalizationToUpdate = hospitalizationMapper.toHospitalizationDO(hospitalizationDTO);
        hospitalizationToUpdate.setId(id);

        hospitalizationRepository.save(hospitalizationToUpdate);
    }

    @Override
    public void deleteById(final Integer id) {
        findById(id);
        hospitalizationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        hospitalizationRepository.deleteAll();
    }



}


