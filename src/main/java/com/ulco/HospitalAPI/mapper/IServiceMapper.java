package com.ulco.HospitalAPI.mapper;


import com.ulco.HospitalAPI.dto.ServiceDTO;
import com.ulco.HospitalAPI.model.ServiceDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IServiceMapper {

    ServiceDTO toServiceDTO(ServiceDO serviceDO);

    ServiceDO toServiceDO(ServiceDTO serviceDTO);
}

