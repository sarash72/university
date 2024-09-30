package com.example.doctorappointment.service;

import com.example.doctorappointment.exception.AppointmentNotFoundException;
import com.example.doctorappointment.exception.DateDurationException;
import com.example.doctorappointment.exception.DateException;
import com.example.doctorappointment.exception.OpenAppointmentNotFoundException;
import com.example.doctorappointment.model.entity.Appointment;
import com.example.doctorappointment.model.entity.Patient;
import com.example.doctorappointment.model.repository.AppointmentRepository;
import com.example.doctorappointment.service.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AppointmentService {

    DateUtils dateUtils;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Value("${appointment.durationTime.minutes}")
    static int appointmentDurationTime;

    public void addAppointmentService(Date start, Date end) throws ParseException {
        if (start == null || end == null || start.before(end)) {
            throw new DateException();
        }
        Duration dur = Duration.between((Temporal) start, (Temporal) end);
        if (dur.toMinutes() < appointmentDurationTime) {
            throw new DateDurationException();
        }

        for (int i = start.getMinutes(); i <= end.getMinutes(); i = +appointmentDurationTime) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(start);
            cal.add(Calendar.MINUTE, appointmentDurationTime);
            appointmentRepository.save(new Appointment(dateUtils.convertDateToStringDay(start), createAppointment(cal.getTime(), end)));
        }
    }

    public List<Appointment> getAppointmentByDay(Date day) {
        if (day == null)
            throw new NullPointerException("day is null");
        List<Appointment> appointments = appointmentRepository.findByDay(day);
        return appointments;
    }

    private String createAppointment(Date start, Date end) {
        if (start.getMinutes() + 30 <=   end.getMinutes()) {
            return dateUtils.convertDateToStringDay(start) + " - " + dateUtils.convertDateToStringMinutes(start.getMinutes() + 30);
        } else return null;
    }

    public List<Appointment> getAllAppointment() {

        return appointmentRepository.findAll();
    }

    public List<Appointment> getOpenAppointmentByDay(Date day) {
        List<Appointment> appointments = appointmentRepository.findByDay(day);
        for (Appointment appointment : appointments) {
            if (appointment.getPatient() != null && appointment.getPatient().getId() != 0)
                appointments.remove(appointment);
        }
        return appointments;
    }

    public List<Appointment> getChosenAppointmentByDay(Date day) {
        List<Appointment> appointments = appointmentRepository.findByDay(day);
        for (Appointment appointment : appointments) {
            if (appointment.getPatient() == null || appointment.getPatient().getId() == 0)
                appointments.remove(appointment);
        }
        return appointments;
    }

    public void deleteAppointment(Appointment appointment) throws ParseException {
        if (appointment == null)
            throw new NullPointerException("appointment is null");
        if (getOpenAppointmentByDay(dateUtils.convertStringToDateDay(appointment.getDay())) == null)
            throw new OpenAppointmentNotFoundException("not found open appointment");

        if (appointment.getPatient() != null && appointment.getPatient().getId() != 0)
            throw new AppointmentNotFoundException("this appointment is not open");

        appointmentRepository.delete(appointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment getAppointmentByDayAndAppointmentTime(String day, String appointmentTime) {
        return appointmentRepository.findAppointmentByDayAndAppointmentTime(day, appointmentTime);
    }

    public List<Appointment> getAppointmentByPatient(Patient patient) {
        return appointmentRepository.findAppointmentByPatient(patient);
    }

}
