package com.techlingo.modules.learning.service;

import java.util.List;
import com.techlingo.modules.learning.dto.QuestionResponse;

public interface QuestionService {
    List<QuestionResponse> getQuestionsByLesson(String lessonId);
    QuestionResponse getQuestion(String questionId);
}
