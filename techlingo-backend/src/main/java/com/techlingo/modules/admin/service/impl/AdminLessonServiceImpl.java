package com.techlingo.modules.admin.service.impl;

import org.springframework.stereotype.Service;

import com.techlingo.common.exception.ResourceNotFoundException;
import com.techlingo.modules.admin.dto.CreateLessonRequest;
import com.techlingo.modules.admin.service.AdminLessonService;
import com.techlingo.modules.learning.entity.Course;
import com.techlingo.modules.learning.entity.Lesson;
import com.techlingo.modules.learning.repository.CourseRepository;
import com.techlingo.modules.learning.repository.LessonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminLessonServiceImpl implements AdminLessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    @Override
    public Lesson createLesson(CreateLessonRequest request) {
       Course course = courseRepository
                .findById(request.getCourseId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found"));

        Lesson lesson = Lesson.builder()
                .courseId(course.getId())
                .title(request.getTitle())
                .description(request.getDescription())
                .lessonOrder(request.getLessonOrder())
                .xpReward(request.getXpReward())
                .active(true)
                .build();

        return lessonRepository.save(lesson);
    }
    
}
