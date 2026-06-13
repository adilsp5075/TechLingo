package com.techlingo.modules.learning.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlingo.common.exception.ResourceNotFoundException;
import com.techlingo.modules.learning.dto.QuestionResponse;
import com.techlingo.modules.learning.entity.Question;
import com.techlingo.modules.learning.repository.QuestionRepository;
import com.techlingo.modules.learning.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    @Override
    public List<QuestionResponse> getQuestionsByLesson(String lessonId) {
        return questionRepository.findByLessonId(lessonId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public QuestionResponse getQuestion(String questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question not found"));

        return mapToResponse(question);
    }

    private QuestionResponse mapToResponse(
            Question question) {

        return QuestionResponse.builder()
                .id(question.getId())
                .type(question.getType())
                .difficulty(question.getDifficulty())
                .title(question.getTitle())
                .description(question.getDescription())
                .options(question.getOptions())
                .xpReward(question.getXpReward())
                .build();
    }
    
}
