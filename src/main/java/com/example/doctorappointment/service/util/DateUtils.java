package com.example.doctorappointment.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    SimpleDateFormat formatDay = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat formatMinutes = new SimpleDateFormat("HH:mm");

    public String convertDateToStringDay(Date date) {
        return formatDay.format(date);
    }
    public Date convertStringToDateDay(String date) throws ParseException {
        return formatDay.parse(date);
    }

    public String convertDateToStringMinutes(int date) {
        return formatMinutes.format(date);
    }
    public Date convertStringToDateMinutes(String date) throws ParseException {
        return formatMinutes.parse(date);
    }

}
