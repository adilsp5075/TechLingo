package com.techlingo.modules.learning.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.learning.dto.QuestionResponse;
import com.techlingo.modules.learning.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/api/lessons/{lessonId}/questions")
    public List<QuestionResponse> getQuestions(
            @PathVariable String lessonId) {

        return questionService.getQuestionsByLesson(lessonId);
    }

    @GetMapping("/api/questions/{questionId}")
    public QuestionResponse getQuestion(
            @PathVariable String questionId) {

        return questionService.getQuestion(questionId);
    }
}
