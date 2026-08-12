package com.hospital.hospitalManagementSystem.controllers;

import com.hospital.hospitalManagementSystem.models.Appointment;
import com.hospital.hospitalManagementSystem.services.AppointmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long appointment_id){
        return new ResponseEntity<>(appointmentService.fetchAppointment(appointment_id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return new ResponseEntity<>(appointmentService.fetchAllAppointments(),HttpStatus.OK);
    }

    @PostMapping("/doctors/{doctorId}/patients/{patientId}")
    public ResponseEntity<Appointment> createAppointment(
            @RequestBody Appointment appointment,
            @PathVariable("doctorId") Long doctorId,
            @PathVariable("patientId") Long patientId
    )
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentService.createAppointment(appointment,doctorId,patientId));
    }

    @PutMapping
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment){
       return ResponseEntity.status(HttpStatus.OK)
               .body(appointmentService.updateAppointment(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") Long appointment_id) {
        appointmentService.deleteAppointment(appointment_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
