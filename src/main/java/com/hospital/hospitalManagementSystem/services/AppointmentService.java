package com.hospital.hospitalManagementSystem.services;

import com.hospital.hospitalManagementSystem.models.Appointment;
import com.hospital.hospitalManagementSystem.models.BloodGroupType;
import com.hospital.hospitalManagementSystem.models.Doctor;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.AppointmentRepository;
import com.hospital.hospitalManagementSystem.repositories.DoctorRepository;
import com.hospital.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void createAppointment(Appointment appointment,Long doctor_id, Long patient_id){
        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow(()-> new EntityNotFoundException("Doctor not found : "+ doctor_id));
        Patient patient = patientRepository.findById(patient_id).orElseThrow(()-> new EntityNotFoundException("Patient not found : "+ patient_id));


        if(appointment.getId()!=0L)throw new IllegalArgumentException("Appointment ID can be set from DB only");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        // just to maintain Bi-directional mapping
        doctor.getAppointment().add(appointment);
        patient.getAppointment().add(appointment);

        // have to save the appointment because this is child Entity, JPA will not add this automatically in DB
        appointmentRepository.save(appointment);

//        System.out.println(appointment);
    }


    @Transactional
    public void reAssignDoctorToAppointment(Long appointment_id, Long newDoctor_id){
        Appointment appointment = appointmentRepository.findById(appointment_id).orElseThrow(()->new EntityNotFoundException("Appointment not found in DB"));
        Doctor doctor = doctorRepository.findById(newDoctor_id).orElseThrow(()->new EntityNotFoundException("doctor not found in DB"));

       // it will automatically call the save() method to save this in DB
        appointment.setDoctor(doctor);

        // add appointment to appointment List
        doctor.getAppointment().add(appointment);

        // delete the existing appointment form doctor's appointment-list
        doctor.getAppointment().remove(appointment);

    }

}
