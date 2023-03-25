package com.assignmentsept9.assignment.controller;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CourseService service;


    @PostMapping("/add")
    public ResponseEntity<String> newCourse(@RequestBody Course course){
        return service.addCourse(course);
    }

    @PutMapping("/update")
    public ResponseEntity<String > updateCourse(@RequestBody Course course){
        return  service.updateCourse(course);
    }


    @DeleteMapping("delete/course/{id}")
    public ResponseEntity<String > deleteCourse(@PathVariable Long id){
        return service.deleteCourse(id);
    }
}
