package com.assignmentsept9.assignment.service;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    ResponseEntity<String> addEmployee(Employee employee);

    boolean signIn(String email, String password);

    List<Course> getAllCourses(String email,String password);

    boolean signInWithToken(Double token);

  /*  @Query(value = "select * from Courses c order by c.catagory",nativeQuery = true)
    List<Course> courses;
*/

    List<Course> sortByCategory();

    ResponseEntity<String> reward();
}
