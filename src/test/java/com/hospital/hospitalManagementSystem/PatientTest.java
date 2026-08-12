package com.hospital.hospitalManagementSystem;

import com.hospital.hospitalManagementSystem.models.BloodGroupType;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.PatientRepository;
import com.hospital.hospitalManagementSystem.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void saveNewPatient(){
        Patient patient = new Patient();
        patient.setName("Raja Rahangdale");
        patient.setEmail("rajaRahang@gmail.com");
        patient.setGender("Male");
        patient.setBirthDate(LocalDate.of(2002,11,2));
        patient.setBloodGroup(BloodGroupType.B_POSITIVE);

        patientService.savePatient(patient);
    }

    @Test
    public void updatePatient(){
        Patient patient = patientRepository.findById(21L).orElseThrow();
        patient.setEmail("Raja2002R@gmail.com");
        patient.setName("Raja Powar");

        System.out.println("test end");
        patientService.UpdatePatient(patient);
    }

    @Test
    public void deletePatient(){
        patientService.deletePatient(22L);
    }
}

