package com.example.doctorappointment.service;

import com.example.doctorappointment.model.entity.Appointment;
import com.example.doctorappointment.model.entity.Patient;
import com.example.doctorappointment.model.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PaitionService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentService appointmentService;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<Appointment> getOpenAppointments(Date day) {
        return appointmentService.getOpenAppointmentByDay(day);
    }

    public List<Appointment> getPatientAppointment(String phoneNo) {
        Patient patient = patientRepository.findByPhoneNo(phoneNo);

        if (patient == null)
            throw new NullPointerException("Patient not found");

        return appointmentService.getAppointmentByPatient(patient);
    }

    /**
     * day and appointmentTim not null in appointment
     */
    public boolean takeOpenAppointment(String name, String phoneNo, Appointment appointment) {
        boolean isSelectedSuccessfully = false;
        if (name == null || name.isEmpty())
            throw new RuntimeException("plz enter name");
        if (phoneNo == null || phoneNo.isEmpty())
            throw new RuntimeException("plz enter phoneNo");
        if (appointment == null || appointment.getAppointmentTime() == null || appointment.getDay() == null)
            throw new RuntimeException("plz chose appointment");

        Appointment choseAppointment = appointmentService.getAppointmentByDayAndAppointmentTime(appointment.getDay(), appointment.getAppointmentTime());
        if (choseAppointment == null || choseAppointment.getPatient() != null || choseAppointment.getPatient().getId() != 0)
            throw new RuntimeException("plz chose another appointment");

        Patient patient = patientRepository.findByPhoneNo(phoneNo);
        if (patient == null)
            throw new RuntimeException("Patient not found");

        ArrayList<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment);
        patient.setAppointments(appointments);
        patientRepository.updatePatientById(patient, patient.getId());

        return isSelectedSuccessfully;
    }


}
