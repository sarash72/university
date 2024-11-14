package com.example.university.service.mapper;

import com.example.university.controller.dto.CourseDto;
import com.example.university.model.entity.Course;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    private final Logger logger = LoggerFactory.getLogger(CourseMapper.class);

    public Course convertCourseDtoToCourse(CourseDto courseDto){
        ModelMapper modelMapper = new ModelMapper();

        Course course=modelMapper.map(courseDto, Course.class);
        logger.debug(" courseDto converted to course in convertCourseDtoToCourse function with course :{} ",course.toString());
        return course;

    }
}
