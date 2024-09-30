package com.example.doctorappointment.model.repository;

import com.example.doctorappointment.model.entity.Appointment;
import com.example.doctorappointment.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * Created by royal on 9/15/2024.
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Transactional

    Patient findByPhoneNo(String phoneNo);

    List<Patient> findByAppointmentId(String phoneNo);

    void deleteById(Long id);

    void updatePatientById(Patient patient, Long id);
}
