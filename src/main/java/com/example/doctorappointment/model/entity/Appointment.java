package com.example.doctorappointment.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.swing.*;

/**
 * Created by royal on 9/15/2024.
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "appointment")
public class Appointment {

    public Appointment(String day, String appointment) {
        this.day = day;
        this.appointmentTime = appointment;
    }

    @Id
    private Long id;
    private String day;
    private String appointmentTime;
    @ManyToOne
    @JoinColumn(name = "id")
    private Patient patient;


}
