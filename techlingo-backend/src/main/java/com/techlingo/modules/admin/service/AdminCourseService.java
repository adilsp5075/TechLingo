package com.techlingo.modules.admin.service;

import com.techlingo.modules.admin.dto.CreateCourseRequest;
import com.techlingo.modules.learning.entity.Course;

public interface AdminCourseService {
    Course createCourse(CreateCourseRequest request);
}
