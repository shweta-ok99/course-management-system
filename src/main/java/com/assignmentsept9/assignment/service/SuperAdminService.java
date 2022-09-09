package com.assignmentsept9.assignment.service;

import com.assignmentsept9.assignment.domain.Course;

public interface SuperAdminService {
    boolean permit(Course course);
}
