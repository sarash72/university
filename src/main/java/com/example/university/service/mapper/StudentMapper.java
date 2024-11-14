package com.example.university.service.mapper;

import com.example.university.controller.dto.StudentDto;
import com.example.university.model.entity.Student;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    private final Logger logger = LoggerFactory.getLogger(StudentMapper.class);

    public Student convertStudentDtoToStudent(StudentDto studentDto){
        ModelMapper modelMapper = new ModelMapper();

        Student student=modelMapper.map(studentDto, Student.class);
        logger.debug(" studentDto converted to student in convertStudentDtoToStudent function with student :{} ",student.toString());
        return student;

    }
}
