package com.ulco.HospitalAPI.mapper;


import com.ulco.HospitalAPI.dto.PatientDTO;
import com.ulco.HospitalAPI.model.PatientDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPatientMapper {

    PatientDTO toPatientDTO(PatientDO patientDO);

    PatientDO toPatientDO(PatientDTO patientDTO);
}

