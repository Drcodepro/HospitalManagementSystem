package com.hospital.hospitalManagementSystem.repositories;

import com.hospital.hospitalManagementSystem.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}