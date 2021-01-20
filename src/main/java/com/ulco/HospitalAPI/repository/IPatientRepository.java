package com.ulco.HospitalAPI.repository;


import com.ulco.HospitalAPI.model.DoctorDO;
import com.ulco.HospitalAPI.model.PatientDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<PatientDO, Integer> {
    List<PatientDO> findByDoctor(Integer id);
}
