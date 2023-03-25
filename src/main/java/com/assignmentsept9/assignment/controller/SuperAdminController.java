package com.assignmentsept9.assignment.controller;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.service.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperAdminController {

    @Autowired
    SuperAdminService superAdminService;

    @GetMapping("/permit")
    public boolean permit(Course course){
        return superAdminService.permit(course);
    }
}
