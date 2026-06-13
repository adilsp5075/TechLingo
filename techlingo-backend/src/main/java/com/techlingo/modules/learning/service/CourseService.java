package com.techlingo.modules.learning.service;

import java.util.List;
import com.techlingo.modules.learning.dto.CourseResponse;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourse(String courseId);
}
