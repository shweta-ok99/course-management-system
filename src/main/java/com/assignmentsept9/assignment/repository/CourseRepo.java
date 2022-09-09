package com.assignmentsept9.assignment.repository;

import com.assignmentsept9.assignment.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
