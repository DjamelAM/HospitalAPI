package com.ulco.HospitalAPI.controller;

import com.ulco.HospitalAPI.dto.PatientDTO;

import com.ulco.HospitalAPI.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    @Autowired
    private IPatientService patientService;

    @GetMapping
    public List<PatientDTO> getAll() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    public PatientDTO findById(@PathVariable Integer id) {
        return patientService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PatientDTO patient) {



        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patientService.save(patient))
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody PatientDTO upgradedPatient) {
        patientService.update(id, upgradedPatient);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll() {
        patientService.deleteAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        patientService.deleteById(id);
    }
}
