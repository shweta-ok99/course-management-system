package com.assignmentsept9.assignment.service;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
import com.assignmentsept9.assignment.dto.SignInDto;
import com.assignmentsept9.assignment.dto.SignUpDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<String> addEmployee(SignUpDto signUpDto);

    ResponseEntity<String> signIn(SignInDto signInDto);

    ResponseEntity<Object> getAllCourses(SignInDto signInDto);

    boolean signInWithToken(Double token);

  /*  @Query(value = "select * from Courses c order by c.catagory",nativeQuery = true)
    List<Course> courses;
*/

    List<Course> sortByCategory();

    ResponseEntity<String> reward();
}
