package com.assignmentsept9.assignment.service.impl;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.repository.CourseRepo;
import com.assignmentsept9.assignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public ResponseEntity<String> addCourse(Course course) {
        courseRepo.save(course);
        return  new ResponseEntity<>("Course_saved_successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateCourse(Course course) {
        courseRepo.save(course);
        return new ResponseEntity<>("Course_updated_successfully",HttpStatus.CREATED);
    }
}
