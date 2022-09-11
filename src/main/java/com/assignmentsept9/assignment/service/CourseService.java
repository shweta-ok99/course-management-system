package com.assignmentsept9.assignment.service;

import com.assignmentsept9.assignment.domain.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {
    ResponseEntity<String> addCourse(Course course);

    ResponseEntity<String> updateCourse(Course course);

    ResponseEntity<String> deleteCourse(Long id);
}
