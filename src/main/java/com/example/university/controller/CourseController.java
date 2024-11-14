package com.example.university.controller;

import com.example.university.controller.dto.CourseDto;
import com.example.university.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;


/**
 * Created by shirdel on 9/15/2024.
 */

@RestController
@RequestMapping(path = "/Course")
public class CourseController {

    CourseService courseService;

    @PostMapping("/addCourse")
    public void addAppointmentService(@RequestParam CourseDto courseDto) throws ParseException {
        courseService.addCourseService(courseDto);
    }

}