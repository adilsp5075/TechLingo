package com.techlingo.modules.learning.service.impl;

import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.techlingo.common.exception.ResourceNotFoundException;
import com.techlingo.modules.learning.entity.Lesson;
import com.techlingo.modules.learning.entity.LessonProgress;
import com.techlingo.modules.learning.entity.Question;
import com.techlingo.modules.learning.enums.LessonStatus;
import com.techlingo.modules.learning.repository.LessonProgressRepository;
import com.techlingo.modules.learning.repository.LessonRepository;
import com.techlingo.modules.learning.repository.QuestionRepository;
import com.techlingo.modules.learning.service.ProgressionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgressionServiceImpl implements ProgressionService{

    private final QuestionRepository questionRepository;

    private final LessonRepository lessonRepository;

    private final LessonProgressRepository lessonProgressRepository;

    @Override
    public boolean markQuestionCompleted(String userId, String questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Question not found"));
        Lesson lesson = lessonRepository.findById(
                        question.getLessonId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Lesson not found"));
        LessonProgress progress =
                lessonProgressRepository
                        .findByUserIdAndLessonId(
                                userId,
                                lesson.getId())
                        .orElseGet(() ->
                                createProgress(
                                        userId,
                                        lesson.getId()));
        
        progress.getCompletedQuestionIds()
                .add(questionId);

        lessonProgressRepository.save(progress);

        long totalQuestions =
                questionRepository.countByLessonId(
                        lesson.getId());

        if (progress.getCompletedQuestionIds().size()
                >= totalQuestions) {
            completeLesson(
                    progress,
                    lesson
            );
            return true;
        }
        return false;
    }

    private void completeLesson(LessonProgress progress, Lesson lesson) {
        progress.setStatus(
                LessonStatus.COMPLETED);
        lessonProgressRepository.save(progress);

        Lesson nextLesson = lessonRepository
                .findByCourseIdAndLessonOrder(
                        lesson.getCourseId(),
                        lesson.getLessonOrder() + 1
                )
                .orElse(null);
        
        if(nextLesson != null){
            LessonProgress nextProgress = lessonProgressRepository
                    .findByUserIdAndLessonId(
                            progress.getUserId(),
                            nextLesson.getId()
                    )
                    .orElse(
                            LessonProgress.builder()
                                    .userId(progress.getUserId())
                                    .lessonId(nextLesson.getId())
                                    .status(
                                        LessonStatus.IN_PROGRESS
                                    )
                                    .completedQuestionIds(
                                            new HashSet<>())
                                    .build()
                    );
            lessonProgressRepository.save(nextProgress);
        }
    }

    private LessonProgress createProgress(String userId, String lessonId) {
        LessonProgress progress =
                LessonProgress.builder()
                        .userId(userId)
                        .lessonId(lessonId)
                        .status(LessonStatus.IN_PROGRESS)
                        .completedQuestionIds(
                                new HashSet<>())
                        .build();
        return lessonProgressRepository.save(progress);
    }

    @Override
    public void initializeCourseProgress(String userId, String courseId) {

        Lesson firstLesson = lessonRepository
            .findByCourseIdOrderByLessonOrder(courseId)
            .stream()
            .findFirst()
            .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "No lessons found for course"));

        boolean exists =
            lessonProgressRepository
                    .findByUserIdAndLessonId(
                            userId,
                            firstLesson.getId())
                    .isPresent();

        if (exists) {
         return;
        }

        LessonProgress progress =
            LessonProgress.builder()
                    .userId(userId)
                    .lessonId(firstLesson.getId())
                    .status(LessonStatus.IN_PROGRESS)
                    .completedQuestionIds(
                            new HashSet<>())
                    .build();

        lessonProgressRepository.save(progress);
    }
    
}
