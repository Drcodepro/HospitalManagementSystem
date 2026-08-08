package com.hospital.hospitalManagementSystem;

import com.hospital.hospitalManagementSystem.models.Insurance;
import com.hospital.hospitalManagementSystem.services.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    InsuranceService insuranceService;

    @Test
    public void addInsuranceToPatient(){
        Insurance insurance = new Insurance();
        insurance.setProvider("TATALife");
        insurance.setCreatedAt(LocalDateTime.now());
        insurance.setValidUntil(LocalDate.of(2030,8,3));
        insurance.setPolicyNumber("TATALife_136");

      // call the service method to add insurance to patient
        insuranceService.addInsurance(insurance,21L);
    }

    @Test
    public void deleteInsurance(){
        insuranceService.deleteInsurance(2L);
    }
}
