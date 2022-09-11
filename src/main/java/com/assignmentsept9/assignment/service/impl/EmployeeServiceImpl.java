package com.assignmentsept9.assignment.service.impl;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
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
    public ResponseEntity<String> addEmployee(Employee employee) {
        if (employee == null) {
            employee = new Employee();
            repo.save(employee);
            return new ResponseEntity<>("Account Created Successfully", HttpStatus.CREATED);
        }
        repo.save(employee);
        return new ResponseEntity<>("Account Created Successfully", HttpStatus.CREATED);
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
