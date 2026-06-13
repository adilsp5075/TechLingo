package com.techlingo.modules.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.admin.dto.CreateCourseRequest;
import com.techlingo.modules.admin.service.AdminCourseService;
import com.techlingo.modules.learning.entity.Course;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/courses")
@RequiredArgsConstructor
public class AdminCourseController {
    private final AdminCourseService adminCourseService;

    @PostMapping
    public Course createCourse(
            @Valid
            @RequestBody
            CreateCourseRequest request) {

        return adminCourseService.createCourse(request);
    }
}
