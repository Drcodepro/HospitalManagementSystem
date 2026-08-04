package com.hospital.hospitalManagementSystem.repositories;

import com.hospital.hospitalManagementSystem.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}