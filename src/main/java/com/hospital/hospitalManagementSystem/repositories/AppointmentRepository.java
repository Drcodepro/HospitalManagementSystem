package com.hospital.hospitalManagementSystem.repositories;

import com.hospital.hospitalManagementSystem.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    public List<Appointment> findByDoctorIdAndPatientId(Long doctorId, Long PatientId);
}