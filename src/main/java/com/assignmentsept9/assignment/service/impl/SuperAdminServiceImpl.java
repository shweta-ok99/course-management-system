package com.assignmentsept9.assignment.service.impl;

import com.assignmentsept9.assignment.domain.Course;
import com.assignmentsept9.assignment.service.SuperAdminService;
import org.springframework.stereotype.Service;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
    @Override
    public boolean permit(Course course) {
        return false;
    }
}
