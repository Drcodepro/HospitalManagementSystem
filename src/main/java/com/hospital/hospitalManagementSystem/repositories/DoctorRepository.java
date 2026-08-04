package com.hospital.hospitalManagementSystem.repositories;

import com.hospital.hospitalManagementSystem.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}