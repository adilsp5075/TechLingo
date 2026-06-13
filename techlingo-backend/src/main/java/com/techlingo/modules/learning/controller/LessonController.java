package com.techlingo.modules.learning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.learning.dto.LessonResponse;
import com.techlingo.modules.learning.service.LessonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;
    
    @GetMapping("/api/courses/{courseId}/lessons")
    public List<LessonResponse> getLessons(
            @PathVariable String courseId) {

        return lessonService.getLessonsByCourse(courseId);
    }

    @GetMapping("/api/lessons/{lessonId}")
    public LessonResponse getLesson(
            @PathVariable String lessonId) {

        return lessonService.getLesson(lessonId);
    }
}
