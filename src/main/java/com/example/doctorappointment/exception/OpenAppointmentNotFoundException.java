package com.example.doctorappointment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OpenAppointmentNotFoundException extends RuntimeException{
    public OpenAppointmentNotFoundException(String message) {
        super(message);
    }
}
