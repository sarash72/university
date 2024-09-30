package com.example.doctorappointment.controller;

import com.example.doctorappointment.model.entity.Appointment;
import com.example.doctorappointment.model.entity.Patient;
import com.example.doctorappointment.service.AppointmentService;
import com.example.doctorappointment.service.PaitionService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by royal on 9/15/2024.
 */

@RestController
@RequestMapping(path = "/doctorAppointment")
public class AppointmentController {

    AppointmentService appointmentService;
    PaitionService paitionService;

    @PostMapping("/addAppointmentService")
    public void addAppointmentService(@RequestParam Date start, @RequestParam Date end) throws ParseException {
        appointmentService.addAppointmentService(start, end);
    }

    @GetMapping("/getAppointmentByDay")
    public List<Appointment> getAppointmentByDay(@RequestParam Date day) {
        return appointmentService.getAppointmentByDay(day);
    }

    @GetMapping("/getAllAppointment")
    public List<Appointment> getAllAppointment() {
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/getOpenAppointmentByDay")
    public List<Appointment> getOpenAppointmentByDay(@RequestParam Date day) {
        return appointmentService.getOpenAppointmentByDay(day);
    }

    @GetMapping("/getChosenAppointmentByDay")
    public List<Appointment> getChosenAppointmentByDay(@RequestParam Date day) {
        return appointmentService.getChosenAppointmentByDay(day);
    }

    @DeleteMapping("/deleteAppointment")
    public void deleteAppointment(@RequestParam Appointment appointment) throws ParseException {
         appointmentService.deleteAppointment(appointment);
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients() {
        return paitionService.getAllPatients();
    }

    @GetMapping("/getPatientAppointment")
    public List<Appointment> getPatientAppointment(String phoneNo) {
        return paitionService.getPatientAppointment(phoneNo);
    }

    @PutMapping("/takeOpenAppointment")
    public boolean takeOpenAppointment(@RequestParam String name, @RequestParam String phoneNo, @RequestParam Appointment appointment) {
        return paitionService.takeOpenAppointment(name,phoneNo,appointment);
    }
}
