package com.assignmentsept9.assignment.employee;

import com.assignmentsept9.assignment.domain.Course;
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

    @GetMapping("/get/courses")
    public List<Course> getCourses(@RequestHeader String email,@RequestHeader String password){
        return employeeService.getAllCourses(email,password);
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
