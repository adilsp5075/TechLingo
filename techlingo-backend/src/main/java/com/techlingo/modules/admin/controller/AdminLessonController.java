package com.techlingo.modules.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.admin.dto.CreateLessonRequest;
import com.techlingo.modules.admin.service.AdminLessonService;
import com.techlingo.modules.learning.entity.Lesson;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/lessons")
@RequiredArgsConstructor
public class AdminLessonController {
    private final AdminLessonService adminLessonService;

    @PostMapping
    public Lesson createLesson(
            @Valid
            @RequestBody
            CreateLessonRequest request) {

        return adminLessonService.createLesson(request);
    }
}
