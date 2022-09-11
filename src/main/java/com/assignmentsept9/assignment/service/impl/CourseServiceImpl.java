package com.assignmentsept9.assignment.service.impl;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.repository.CourseRepo;
import com.assignmentsept9.assignment.service.CourseService;
import com.assignmentsept9.assignment.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    SuperAdminService superAdminService;

    @Override
    public ResponseEntity<String> addCourse(Course course) {
        courseRepo.save(course);
        superAdminService.permit(course);
        return new ResponseEntity<>("Course_created_successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateCourse(Course course) {
        courseRepo.save(course);
        return new ResponseEntity<>("Course_updated_successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCourse(Long id) {
       List<Course> list= courseRepo.findAll();
       for(Course course: list){
           if (course.getId().equals(id)){
               courseRepo.deleteById(id);
               return new ResponseEntity<>("Course_removed_successfully", HttpStatus.OK);
           }
       }
       return new ResponseEntity<>("COURSE_NOT_FOUND",HttpStatus.NOT_FOUND);
    }
}
