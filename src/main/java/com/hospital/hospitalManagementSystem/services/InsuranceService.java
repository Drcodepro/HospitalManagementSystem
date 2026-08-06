package com.hospital.hospitalManagementSystem.services;

import com.hospital.hospitalManagementSystem.models.Appointment;
import com.hospital.hospitalManagementSystem.models.Insurance;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.AppointmentRepository;
import com.hospital.hospitalManagementSystem.repositories.InsuranceRepository;
import com.hospital.hospitalManagementSystem.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public void addInsurance(Insurance insurance, Long patient_id){

        Patient patient = patientRepository.findById(patient_id).orElseThrow(
                ()-> new EntityNotFoundException("patient not found with Id: " + patient_id )
        );


        // will automatically update the Patient also create and save the Insurance in DB (Dirty checking and Cascading)
        patient.setInsurance(insurance);
        // optional but to implement the Bi-direction connection
        insurance.setPatient(patient);

        System.out.println(patient);
    }


    @Transactional
    public void deleteInsurance(Long insurance_id){

        Insurance insurance = insuranceRepository.findById(insurance_id)
                .orElseThrow(() -> new EntityNotFoundException("Insurance not found with ID: " + insurance_id));

        Patient patient = insurance.getPatient();
        patient.setInsurance(null);

        insuranceRepository.delete(insurance);
    }

}
