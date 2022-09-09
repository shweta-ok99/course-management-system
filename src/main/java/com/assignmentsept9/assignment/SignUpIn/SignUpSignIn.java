package com.assignmentsept9.assignment.SignUpIn;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
import com.assignmentsept9.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SignUpSignIn {

    @Autowired
    EmployeeService service;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }

    @PostMapping("/signIn/{email}")
    public ResponseEntity<String > signIn(@PathVariable String email, @RequestBody String password){
        return service.signIn(email,password);
    }

    @GetMapping("/view/course")
    public List<Course> getCourse(){
        return service.getAllCourses();
    }



}
