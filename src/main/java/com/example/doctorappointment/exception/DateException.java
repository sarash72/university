package com.example.doctorappointment.exception;

public class DateException extends RuntimeException{

    private String code;

    public DateException() {
     code ="-1";
    }

    @Override
    public String getMessage() {
        return "لطفا تاریخ مناسب انتخاب فرمایید";
    }
}
