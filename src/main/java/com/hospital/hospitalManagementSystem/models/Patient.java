package com.hospital.hospitalManagementSystem.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String Gender;
    private LocalDate birthDate;
    private String email;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // in production use ORDINAL that stores as number and uses less space
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    // Cascade MERGE will update the child(Insurance) if parent(Patient) Entity updated
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Insurance insurance;

    // CascadeType.Remove =  if parent is deleted then child(appointments) also gets deleted from DB
    // orphanRemoval=true == if you removed any Appointment from List (patient.getAppointment.remove(apmt1)) so delete it from DB as well
    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Appointment> appointment;
}
