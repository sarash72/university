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
public class CourseDto {
    private String name;
    private String description;
    private MasterDto master;
    private List<StudentDto> studentList = new ArrayList<>();
}
