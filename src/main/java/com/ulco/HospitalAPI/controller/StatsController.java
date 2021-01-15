package com.ulco.HospitalAPI.controller;

import com.ulco.HospitalAPI.dto.PatientDTO;
import com.ulco.HospitalAPI.dto.ServiceDTO;
import com.ulco.HospitalAPI.dto.ServiceHospitalizationsDTO;
import com.ulco.HospitalAPI.service.IDoctorService;
import com.ulco.HospitalAPI.service.IHospitalizationService;
import com.ulco.HospitalAPI.service.IPatientService;
import com.ulco.HospitalAPI.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IHospitalizationService hospitalizationService;

    @GetMapping

    public Integer getNbDoctors() {

        return doctorService.findAll().size();
    }
    public Integer getNbServices() {

        return serviceService.findAll().size();
    }

    public Integer getNbPatients() {

        return patientService.findAll().size();
    }

    public List<ServiceHospitalizationsDTO> getServiceHospitalizations () {
        List<ServiceHospitalizationsDTO> serviceHospitalizationsDTOList = null;
         serviceService.findAll().stream().map(service-> serviceHospitalizationsDTOList.add(new ServiceHospitalizationsDTO(service.getName(), (int) (long) hospitalizationService.findAll().stream().filter(d-> d.getServiceId().equals(service.getName())).count())));

         return serviceHospitalizationsDTOList;
    }

}
