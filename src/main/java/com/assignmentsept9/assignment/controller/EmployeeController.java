package com.assignmentsept9.assignment.controller;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.dto.SignInDto;
import com.assignmentsept9.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/get/courses")
    public ResponseEntity<Object>  getCourses(@RequestBody SignInDto signInDto){
        return employeeService.getAllCourses(signInDto);
    }

    @GetMapping("/token/login")
    public boolean loginWithToken(@RequestHeader Double token){
        return employeeService.signInWithToken(token);
    }

    @GetMapping("/course/category")
    public List<Course> sortedCategoryWise(){
        return employeeService.sortByCategory();
    }

    @GetMapping("/reward")
    public ResponseEntity<String > reward(){
        return employeeService.reward();
    }
}
