package com.techlingo.modules.learning.service;

public interface ProgressionService {
    boolean markQuestionCompleted(
            String userId,
            String questionId
    );

    void initializeCourseProgress(
            String userId,
            String courseId
    );
}
