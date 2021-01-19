package com.ulco.HospitalAPI.controller;

import com.ulco.HospitalAPI.dto.HospitalizationDTO;
import com.ulco.HospitalAPI.dto.HospitalizationDTO;
import com.ulco.HospitalAPI.service.IHospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/hospitalizations")
public class HospitalizationsController {
    @Autowired
    private IHospitalizationService hospitalizationService;

    @GetMapping
    public List<HospitalizationDTO> getAll() {
        return hospitalizationService.findAll();
    }

    @GetMapping("/{id}")
    public HospitalizationDTO findById(@PathVariable Integer id) {
        return hospitalizationService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody HospitalizationDTO hospitalization) {


        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hospitalizationService.save(hospitalization))
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody HospitalizationDTO upgradedHospitalization) {
        hospitalizationService.update(id, upgradedHospitalization);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll() {
        hospitalizationService.deleteAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        hospitalizationService.deleteById(id);
    }
}
