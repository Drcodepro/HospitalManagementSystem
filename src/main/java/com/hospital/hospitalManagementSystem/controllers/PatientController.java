package com.hospital.hospitalManagementSystem.controllers;

import com.hospital.hospitalManagementSystem.models.Appointment;
import com.hospital.hospitalManagementSystem.models.BloodGroupType;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") Long patient_id){
        return new ResponseEntity<>(patientService.fetchPatent(patient_id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllAppointments(){
        return new ResponseEntity<>(patientService.fetchAllPatents(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient)
    {
        System.out.println("rajjjjjjjjjjjjjj");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(patientService.savePatient(patient));
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        return ResponseEntity.status(HttpStatus.OK)
                .body(patientService.UpdatePatient(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long patient_id){
        patientService.deletePatient(patient_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
