package com.ulco.HospitalAPI.mapper;


import com.ulco.HospitalAPI.dto.HospitalizationDTO;
import com.ulco.HospitalAPI.model.HospitalizationDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IHospitalizationMapper {

    HospitalizationDTO toHospitalizationDTO(HospitalizationDO hospitalizationDO);

    HospitalizationDO toHospitalizationDO(HospitalizationDTO hospitalizationDTO);
}

