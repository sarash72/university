package com.example.university.service;

import com.example.university.controller.dto.CourseDto;
import com.example.university.model.entity.Course;
import com.example.university.model.repository.CourseRepository;
import com.example.university.service.mapper.CourseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;


@Service
@Transactional
public class CourseService {
    private final Logger logger = LoggerFactory.getLogger(MasterService.class);

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public void addCourseService(CourseDto courseDto) throws ParseException {
        courseRepository.save(courseMapper.convertCourseDtoToCourse(courseDto));
        logger.info("added new course :{}", courseDto.toString());

    }

    public List<Course> getAllCourse(){
      return courseRepository.findAll();
    }

    public boolean isExist(Course course) {
        logger.debug("start isExist function with course:{}", course.toString());
        return courseRepository.existsById(course.getId());
    }
}
