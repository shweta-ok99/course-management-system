package com.assignmentsept9.assignment.service.impl;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
import com.assignmentsept9.assignment.repository.CourseRepo;
import com.assignmentsept9.assignment.repository.EmployeeRepo;
import com.assignmentsept9.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo repo;

    @Autowired
    CourseRepo courseRepo;
    @Override
    public ResponseEntity<String> addEmployee(Employee employee) {
        repo.save(employee);
        return  new ResponseEntity<>("Account Created Successfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> signIn(String email, String password) {
        Optional<Employee> optional= repo.getByEmail(email);
        if (optional.isPresent()){
            String savedpassword= optional.get().getPassword();
            String savedEmail= optional.get().getEmail();
            if (savedpassword.equals(password)&& savedEmail.equals(email))return new ResponseEntity<>("Login Successfull",HttpStatus.OK);
        }

        return new ResponseEntity<>("User_Not_Found",HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> courses= courseRepo.findAll();
        return courses;
    }
}
