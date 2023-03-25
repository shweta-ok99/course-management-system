package com.assignmentsept9.assignment.controller;

import com.assignmentsept9.assignment.dto.SignInDto;
import com.assignmentsept9.assignment.dto.SignUpDto;
import com.assignmentsept9.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignUpSignInController {

    @Autowired
    EmployeeService service;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody SignUpDto signUpDto){
        return service.addEmployee(signUpDto);
    }

    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestBody SignInDto signInDto){
        return service.signIn(signInDto);
    }

}
