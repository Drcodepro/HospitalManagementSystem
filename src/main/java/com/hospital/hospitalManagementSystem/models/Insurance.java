package com.hospital.hospitalManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
    private LocalDateTime createdAt;

}
