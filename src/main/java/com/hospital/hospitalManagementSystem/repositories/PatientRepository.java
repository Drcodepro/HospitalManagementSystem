package com.hospital.hospitalManagementSystem.repositories;

import com.hospital.hospitalManagementSystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}