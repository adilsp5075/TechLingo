package com.techlingo.modules.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.admin.dto.CreateQuestionRequest;
import com.techlingo.modules.admin.service.AdminQuestionService;
import com.techlingo.modules.learning.entity.Question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/questions")
@RequiredArgsConstructor
public class AdminQuestionController {
    private final AdminQuestionService adminQuestionService;
    
    @PostMapping
    public Question createQuestion(
            @Valid
            @RequestBody
            CreateQuestionRequest request) {

        return adminQuestionService.createQuestion(request);
    }
}
