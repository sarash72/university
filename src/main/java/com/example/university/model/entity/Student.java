package com.example.university.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "student")
public class Student {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Long average;
    private String email;
    private String phone;
    private String address;
    private String state;
    private String gender;

    @ManyToMany
    private List<Course> courseList = new ArrayList<>();
}
