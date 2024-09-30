package com.example.doctorappointment.exception;

public class DateDurationException extends RuntimeException {

    private String code;

    public DateDurationException() {
        code = "-2";
    }

    @Override
    public String getMessage() {
        return "تعیین نوبت ویزیت در این زمان امکان پذیر نیست.";
    }
}
