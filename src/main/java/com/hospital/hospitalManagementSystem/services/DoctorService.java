package com.hospital.hospitalManagementSystem.services;


import com.hospital.hospitalManagementSystem.models.Doctor;
import com.hospital.hospitalManagementSystem.models.Patient;
import com.hospital.hospitalManagementSystem.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public void saveDoctor(Doctor doctor){
        if(doctor==null) {
            throw new IllegalArgumentException("Doctor object cannot be null");
        }
        doctorRepository.save(doctor);

    }

    public void UpdateDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    @Transactional
    public void deleteDoctor(Long doctor_id){
        Doctor doctor = doctorRepository.findById(doctor_id).orElseThrow(()->new EntityNotFoundException("Doctor is not found in db"));
        // delete all the appointment connected to Patient
        doctorRepository.deleteById(doctor_id);
    }

}
