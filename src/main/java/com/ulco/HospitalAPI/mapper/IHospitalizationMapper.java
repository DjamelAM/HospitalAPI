package com.ulco.HospitalAPI.mapper;


import com.ulco.HospitalAPI.dto.HospitalizationDTO;
import com.ulco.HospitalAPI.model.HospitalizationDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IHospitalizationMapper {
    @Mappings({
            @Mapping(target="startDate", source = "startDate", dateFormat = "dd-MM-yyyy"),
            @Mapping(target="endDate", source="endDate",
                    dateFormat="dd-MM-yyyy")})
    HospitalizationDTO toHospitalizationDTO(HospitalizationDO hospitalizationDO);
    @Mappings({
            @Mapping(target="startDate", source="startDate",
                    dateFormat="dd-MM-yyyy"),
            @Mapping(target="endDate", source="endDate",
                    dateFormat="dd-MM-yyyy")})
    HospitalizationDO toHospitalizationDO(HospitalizationDTO hospitalizationDTO);
}

