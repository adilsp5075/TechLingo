package com.techlingo.modules.submission.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.submission.dto.SubmissionResponse;
import com.techlingo.modules.submission.dto.SubmitAnswerRequest;
import com.techlingo.modules.submission.service.SubmissionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;
    
    @PostMapping
    public SubmissionResponse submitAnswer(
            @Valid
            @RequestBody
            SubmitAnswerRequest request) {
        return submissionService
                .submitAnswer(request);
    }
}
