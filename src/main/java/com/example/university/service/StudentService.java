package com.example.university.service;

import com.example.university.controller.dto.CourseDto;
import com.example.university.controller.dto.StudentDto;
import com.example.university.model.entity.Course;
import com.example.university.model.entity.Student;
import com.example.university.model.repository.StudentRepository;
import com.example.university.service.mapper.CourseMapper;
import com.example.university.service.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    public void addStudentService(StudentDto student) throws ParseException {
        studentRepository.save(studentMapper.convertStudentDtoToStudent(student));
        logger.info("added new student :{}", student.toString());
    }

    private boolean isExist(Student student) {
        logger.debug("start isExist function with student:{}", student.toString());
        return studentRepository.existsById(student.getId());
    }

    public boolean chooseCourse(StudentDto studentDto, CourseDto courseDto) {
        logger.info("start chooseCurse with student:{} , course:{}", studentDto.toString(), courseDto.toString());
        Student student = studentMapper.convertStudentDtoToStudent(studentDto);
        Course course = courseMapper.convertCourseDtoToCourse(courseDto);

        if (student == null || course == null || !isExist(student) || !courseService.isExist(course))
            return false;

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        course.setStudentList(studentList);

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);
        student.setCourseList(courseList);
        logger.info("end chooseCurse with student:{} , course:{}", student.toString(), course.toString());
        return true;
    }
}
