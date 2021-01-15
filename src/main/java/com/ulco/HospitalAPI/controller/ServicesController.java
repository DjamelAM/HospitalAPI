package com.ulco.HospitalAPI.controller;

import com.ulco.HospitalAPI.dto.ServiceDTO;
import com.ulco.HospitalAPI.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private IServiceService serviceService;

    @GetMapping
    public List<ServiceDTO> getAll() {
        return serviceService.findAll();
    }

    @GetMapping("/{id}")
    public ServiceDTO findById(@PathVariable Integer id) {
        return serviceService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ServiceDTO service) {



        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(serviceService.save(service))
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ServiceDTO upgradedService) {
        serviceService.update(id, upgradedService);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll() {
        serviceService.deleteAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        serviceService.deleteById(id);
    }
}
