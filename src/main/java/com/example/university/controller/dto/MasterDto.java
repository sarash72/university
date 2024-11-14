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
public class MasterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String state;
    private List<CourseDto> courseList = new ArrayList<>();
}
