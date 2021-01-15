package com.ulco.HospitalAPI.repository;


import com.ulco.HospitalAPI.model.DoctorDO;
import com.ulco.HospitalAPI.model.HospitalizationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHospitalizationRepository extends JpaRepository<HospitalizationDO, Integer> {
}
