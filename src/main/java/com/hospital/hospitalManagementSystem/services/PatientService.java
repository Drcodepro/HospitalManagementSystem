package com.hospital.hospitalManagementSystem.services;

import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService{
    private final PatientRepository patientRepository;

    public void savePatient(Patient patient){
        if(patient==null) {
            throw new IllegalArgumentException("Patient object cannot be null");
        }
        patientRepository.save(patient);

    }

    public void UpdatePatient(Patient patient){
        patientRepository.save(patient);
    }

    @Transactional
    public void deletePatient(Long patient_id){
        Patient patient = patientRepository.findById(patient_id).orElseThrow(()->new EntityNotFoundException("patient is not found in db"));
        // delete all the appointment connected to Patient
        patientRepository.deleteById(patient_id);
    }
}
