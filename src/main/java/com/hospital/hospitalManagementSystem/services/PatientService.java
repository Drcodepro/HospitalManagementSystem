package com.hospital.hospitalManagementSystem.services;

import com.hospital.hospitalManagementSystem.models.Appointment;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService{
    private final PatientRepository patientRepository;

    @Transactional
    public List<Patient> fetchAllPatents(){
        return patientRepository.findAll();
    }

    @Transactional
    public Patient fetchPatent(Long patient_id){
        return patientRepository.findById(patient_id).orElseThrow(()-> new EntityNotFoundException("Patient is not present with id - "+patient_id));
    }

    public Patient savePatient(Patient patient){
        if(patient==null) {
            throw new IllegalArgumentException("Patient object cannot be null");
        }
        return patientRepository.save(patient);
    }

    public Patient UpdatePatient(Patient patient){
        return patientRepository.save(patient);
    }

    @Transactional
    public void deletePatient(Long patient_id){
        Patient patient = patientRepository.findById(patient_id).orElseThrow(()->new EntityNotFoundException("patient is not found in db"));
        // delete all the appointment connected to Patient
        patientRepository.deleteById(patient_id);
    }
}
