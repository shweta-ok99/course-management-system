package com.assignmentsept9.assignment.service;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<String> addEmployee(Employee employee);

    ResponseEntity<String> signIn(String email, String password);

    List<Course> getAllCourses();
}
