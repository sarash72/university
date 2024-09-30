package com.example.doctorappointment.model.repository;

import com.example.doctorappointment.model.entity.Appointment;
import com.example.doctorappointment.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by royal on 9/15/2024.
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Transactional
    default Appointment saveAll(List<Appointment> entity) {
        return (Appointment) save(entity);
    }

    List<Appointment> findByDay(Date day);

    Appointment findById(Long id);

    Appointment findAppointmentByDayAndAppointmentTime(String day, String appointmentTime);

    List<Appointment> findAppointmentByPatient(Patient patient);
}
