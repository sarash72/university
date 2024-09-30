package com.example.doctorappointment.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

/**
 * Created by royal on 9/15/2024.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "patient")
public class Patient {

    @Id
    private Long id;

    String name;
    @Column(unique = true)
    String phoneNo;

    @OneToMany(fetch= FetchType.LAZY , cascade=CascadeType.ALL , mappedBy="patient")
    List<Appointment> appointments;
}
