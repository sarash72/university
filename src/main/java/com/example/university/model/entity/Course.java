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
@Table(name = "course")
public class Course {

    @Id
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id")
    private Master master;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();
}
