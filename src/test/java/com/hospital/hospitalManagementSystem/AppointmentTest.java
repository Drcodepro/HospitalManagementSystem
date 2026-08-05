package com.hospital.hospitalManagementSystem;

import com.hospital.hospitalManagementSystem.models.Appointment;
import com.hospital.hospitalManagementSystem.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    AppointmentService appointmentService;

    @Test
    public void TestAppointment(){
        Appointment appointment = new Appointment();
        appointment.setAppointmentTime(LocalDateTime.now());
        appointment.setReason("chest pain");
        appointment.setStatus("pending");
        appointmentService.createAppointment(appointment,1L,2L);
    }

    @Test
    public void updateAppointment(){
        appointmentService.reAssignDoctorToAppointment(2L,7L);
    }
}
