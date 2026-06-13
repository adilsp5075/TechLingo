package com.techlingo.modules.admin.service;

import com.techlingo.modules.admin.dto.CreateQuestionRequest;
import com.techlingo.modules.learning.entity.Question;

public interface AdminQuestionService {
    Question createQuestion(
            CreateQuestionRequest request);
}
