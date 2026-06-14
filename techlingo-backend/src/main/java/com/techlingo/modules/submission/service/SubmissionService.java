package com.techlingo.modules.submission.service;

import com.techlingo.modules.submission.dto.SubmissionResponse;
import com.techlingo.modules.submission.dto.SubmitAnswerRequest;

public interface SubmissionService {
    SubmissionResponse submitAnswer(
            SubmitAnswerRequest request);
}
