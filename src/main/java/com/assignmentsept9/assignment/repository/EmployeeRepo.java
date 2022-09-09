package com.assignmentsept9.assignment.repository;

import com.assignmentsept9.assignment.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepo extends JpaRepository< Employee,Long>{
    @Override
    Optional<Employee> findById(Long aLong);

    Optional<Employee> getByEmail(String email);
}
