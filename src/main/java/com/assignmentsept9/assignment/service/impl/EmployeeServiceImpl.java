package com.assignmentsept9.assignment.service.impl;

import com.assignmentsept9.assignment.common.Constant;
import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
import com.assignmentsept9.assignment.dto.SignUpDto;
import com.assignmentsept9.assignment.repository.CourseRepo;
import com.assignmentsept9.assignment.repository.EmployeeRepo;
import com.assignmentsept9.assignment.service.EmployeeService;
import com.assignmentsept9.assignment.service.SuperAdminService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.assignmentsept9.assignment.BcryptPasswordEncoder.BcryptEncoder.encodePassword;

@Log
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo repo;

    @Autowired
    SuperAdminService superAdminService;
    @Autowired
    CourseRepo courseRepo;


    @Override
    public ResponseEntity<String> addEmployee(SignUpDto signUpDto) {
        Optional<Employee> byEmail = repo.findByEmail(signUpDto.getEmail());
        if (byEmail.isPresent()){
            return new ResponseEntity<>(Constant.ALREADY_EXISTS+signUpDto.getEmail(),HttpStatus.BAD_REQUEST);
        }
        Employee newEmployee = createEmployee(signUpDto);
        repo.save(newEmployee);
        return new ResponseEntity<>(Constant.ACCOUNT_CREATED, HttpStatus.CREATED);
    }

    private Employee createEmployee(SignUpDto signUpDto) {
        Employee employee= new Employee();
        employee.setEmail(signUpDto.getEmail());
        employee.setName(signUpDto.getName());
        employee.setRole(signUpDto.getRole());
        employee.setPassword(encodePassword(signUpDto.getPassword()));
        return employee;
    }

    @Override
    public boolean signIn(String email, String password) {
        Optional<Employee> optional = repo.getByEmail(email);
        if (optional.isPresent()) {
            String savedpassword = optional.get().getPassword();
            String savedEmail = optional.get().getEmail();
            if (savedpassword.equals(password) && savedEmail.equals(email)) {
                log.info("USER_SIGN-IN_SUCCESSFUL");
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Course> getAllCourses(String email, String password) {
        if (signIn(email, password)) {
            List<Course> courses = courseRepo.findAll();
            return courses;
        }
        log.info("==========USER_NOT_SIGNED-IN================");
        return null;
    }

    @Override
    public boolean signInWithToken(Double token) {
        Double required= getToken();

        if(token==null||token!=required){
            return false;
        }
        return true;
    }


    @Override
    public List<Course> sortByCategory() {
        List<Course> courses = courseRepo.findAll(Sort.by(Sort.Direction.ASC, "category"));
        return courses;
    }

    @Override
    public ResponseEntity<String> reward() {
        return  new ResponseEntity<>("CONGRATULATIONS_YOU_HAVE_SUCCESSFULLY_COMPLETED_THE_COURSE",HttpStatus.OK);
    }

    private double getToken(){
        return  Math.random();
    }
}
