package com.hospital.hospitalManagementSystem.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn
    // While Printing it will prevent from StackOverflowException
    @ToString.Exclude
    private Patient patient;

    @ManyToOne
    @JoinColumn
    // StackoverflowException (doctor/patient toString again call for Appointment's toString())
    @ToString.Exclude
    private Doctor doctor;
}
