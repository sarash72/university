package com.example.university.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {

    private String firstName;
    private String lastName;
    private Long average;
    private String email;
    private String phone;
    private String address;
    private String state;
    private String gender;
    private List<CourseDto> courseList = new ArrayList<>();
}
