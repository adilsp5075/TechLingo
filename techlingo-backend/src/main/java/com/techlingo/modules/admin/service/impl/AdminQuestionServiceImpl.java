package com.techlingo.modules.admin.service.impl;

import org.springframework.stereotype.Service;

import com.techlingo.common.exception.ResourceNotFoundException;
import com.techlingo.modules.admin.dto.CreateQuestionRequest;
import com.techlingo.modules.admin.service.AdminQuestionService;
import com.techlingo.modules.learning.entity.Lesson;
import com.techlingo.modules.learning.entity.Question;
import com.techlingo.modules.learning.repository.LessonRepository;
import com.techlingo.modules.learning.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminQuestionServiceImpl implements AdminQuestionService{
    private final QuestionRepository questionRepository;
    private final LessonRepository lessonRepository;

    @Override
    public Question createQuestion(CreateQuestionRequest request) {
        Lesson lesson = lessonRepository
                .findById(request.getLessonId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Lesson not found"));
        Question question = Question.builder()
                .lessonId(lesson.getId())
                .type(request.getType())
                .difficulty(request.getDifficulty())
                .title(request.getTitle())
                .description(request.getDescription())
                .options(request.getOptions())
                .correctAnswer(request.getCorrectAnswer())
                .explanation(request.getExplanation())
                .xpReward(request.getXpReward())
                .build();                  
        return questionRepository.save(question);
    }
    
}
