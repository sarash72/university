package com.example.university.controller;

import com.example.university.controller.dto.CourseDto;
import com.example.university.controller.dto.StudentDto;
import com.example.university.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;


/**
 * Created by shirdel on 9/15/2024.
 */

@RestController
@RequestMapping(path = "/Student")
public class StudentController {

    StudentService studentService;

    @PostMapping("/addStident")
    public void addAppointmentService(@RequestParam StudentDto studentDto) throws ParseException {
        studentService.addStudentService(studentDto);
    }

    @PostMapping("/chooseCourse")
    public boolean getAppointmentByDay(@RequestParam StudentDto studentDto, @RequestParam CourseDto courseDto) {
        return studentService.chooseCourse(studentDto,courseDto);
    }


}