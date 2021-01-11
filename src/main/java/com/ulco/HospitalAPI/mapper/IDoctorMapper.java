package com.ulco.HospitalAPI.mapper;


import com.ulco.HospitalAPI.dto.DoctorDTO;
import com.ulco.HospitalAPI.model.DoctorDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDoctorMapper {

    DoctorDTO toDoctorDTO(DoctorDO DoctorDO);

    DoctorDO toDoctorDO(DoctorDTO DoctorDTO);
}

