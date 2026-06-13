package com.techlingo.modules.admin.service.impl;

import org.springframework.stereotype.Service;

import com.techlingo.modules.admin.dto.CreateCourseRequest;
import com.techlingo.modules.admin.service.AdminCourseService;
import com.techlingo.modules.learning.entity.Course;
import com.techlingo.modules.learning.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminCourseServiceImpl implements AdminCourseService{
    private final CourseRepository courseRepository;

    @Override
    public Course createCourse(CreateCourseRequest request) {
        Course course = Course.builder()
                .name(request.getName())
                .description(request.getDescription())
                .iconUrl(request.getIconUrl())
                .active(true)
                .build();

        return courseRepository.save(course);
    }
}
