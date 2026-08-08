package com.hospital.hospitalManagementSystem;

import com.hospital.hospitalManagementSystem.models.BloodGroupType;
import com.hospital.hospitalManagementSystem.models.Doctor;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.DoctorRepository;
import com.hospital.hospitalManagementSystem.repositories.PatientRepository;
import com.hospital.hospitalManagementSystem.services.DoctorService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class DoctorTest {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorService doctorService;

    @Test
    public void saveNewDoctor(){
        Doctor doctor = new Doctor();
        doctor.setName("Raja mishra");
        doctor.setEmail("mishra@gmail.com");
        doctor.setSpecialization("Neurology");
        doctor.setCreatedAt(LocalDateTime.now());

        doctorService.saveDoctor(doctor);
    }

    @Test
    public void updateDoctor(){
        Doctor doctor = doctorRepository.findById(11L).orElseThrow();
        doctor.setEmail("Raja12DR@gmail.com");
        doctor.setName("Raja Rahangdale");

        System.out.println("test end");
        doctorService.UpdateDoctor(doctor);
    }

    @Test
    public void deleteDoctor(){
        doctorService.deleteDoctor(11L);
        // need to add functionality that when doctor delet then in appointment doctor column becomes null
    }

//    @Test
//    @Transactional
//    public void sampleTest(){
//        Doctor doctor = doctorRepository.findById(11L).orElseThrow();
//        System.out.println(doctor.getAppointment());
//    }
}
