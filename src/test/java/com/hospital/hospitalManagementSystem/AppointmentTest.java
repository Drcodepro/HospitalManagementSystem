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
        appointment.setAppointmentTime(LocalDateTime.of(2026, 8, 12, 10, 0, 0));
        appointment.setReason("Head each");
        appointment.setStatus("pending");
        appointmentService.createAppointment(appointment,11L,4L);
    }

    @Test
    public void updateAppointmentDoctor(){
        appointmentService.reAssignDoctorToAppointment(2L,7L);
    }

    @Test
    public void deleteAppointment(){
        appointmentService.deleteAppointment(2L);
    }
}
