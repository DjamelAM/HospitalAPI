package com.ulco.HospitalAPI.repository;


import com.ulco.HospitalAPI.model.DoctorDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<DoctorDO, Integer> {
}
