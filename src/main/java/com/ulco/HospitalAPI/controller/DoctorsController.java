package com.ulco.HospitalAPI.controller;

import com.ulco.HospitalAPI.dto.DoctorDTO;
import com.ulco.HospitalAPI.dto.HospitalizationDTO;
import com.ulco.HospitalAPI.service.DoctorService;
import com.ulco.HospitalAPI.service.IDoctorService;
import com.ulco.HospitalAPI.service.IHospitalizationService;
import com.ulco.HospitalAPI.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

    @Autowired
    private IDoctorService doctorService;

   @Autowired
   private IPatientService patientService;

    @GetMapping
    public List<DoctorDTO> getAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public DoctorDTO findById(@PathVariable Integer id) {
        return doctorService.findById(id);
    }

    @GetMapping("/{id}/patients")
    public HospitalizationDTO findPatientsByDoctor(@PathVariable Integer id) {
        return patientService.findByDoctorId(id);
    }



    @PostMapping
    public ResponseEntity<Void> create(@RequestBody DoctorDTO doctor) {



        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(doctorService.save(doctor))
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody DoctorDTO upgradedDoctor) {
        doctorService.update(id, upgradedDoctor);
    }



}
