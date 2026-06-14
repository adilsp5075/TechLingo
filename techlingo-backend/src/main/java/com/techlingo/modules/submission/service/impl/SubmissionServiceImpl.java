package com.techlingo.modules.submission.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.techlingo.common.exception.ResourceNotFoundException;
import com.techlingo.modules.gamification.service.LivesService;
import com.techlingo.modules.gamification.service.StreakService;
import com.techlingo.modules.gamification.service.XpService;
import com.techlingo.modules.learning.entity.Question;
import com.techlingo.modules.learning.repository.QuestionRepository;
import com.techlingo.modules.learning.service.ProgressionService;
import com.techlingo.modules.submission.dto.SubmissionResponse;
import com.techlingo.modules.submission.dto.SubmitAnswerRequest;
import com.techlingo.modules.submission.evaluator.AnswerEvaluator;
import com.techlingo.modules.submission.factory.EvaluatorFactory;
import com.techlingo.modules.submission.service.SubmissionService;
import com.techlingo.modules.user.entity.User;
import com.techlingo.modules.user.entity.UserStats;
import com.techlingo.modules.user.repository.UserRepository;
import com.techlingo.modules.user.repository.UserStatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {

    private final QuestionRepository questionRepository;

    private final UserRepository userRepository;

    private final UserStatsRepository userStatsRepository;

    private final EvaluatorFactory evaluatorFactory;

    private final XpService xpService;

    private final LivesService livesService;

    private final StreakService streakService;

    private final ProgressionService progressionService;

    @Override
    public SubmissionResponse submitAnswer(SubmitAnswerRequest request) {
        String email =
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found"));
        UserStats stats =
                userStatsRepository.findByUserId(
                                user.getId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Stats not found"));
        Question question =
                questionRepository.findById(
                                request.getQuestionId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Question not found"));
        AnswerEvaluator evaluator =
                evaluatorFactory.getEvaluator(
                        question.getType());
        boolean correct =
                evaluator.evaluate(
                        question,
                        request.getAnswer());
        boolean lessonCompleted =
                progressionService
                        .markQuestionCompleted(
                                user.getId(),
                                question.getId()
                        );
        int xpEarned = 0;
        if (correct) {
            xpEarned = question.getXpReward();
            xpService.awardXp(
                        stats,
                        xpEarned
                );
        }
        else {
            livesService.deductLife(stats);
        }

        streakService.updateStreak(stats);

        userStatsRepository.save(stats);
        return SubmissionResponse.builder()
                .correct(correct)
                .xpEarned(xpEarned)
                .remainingLives(stats.getLives())
                .explanation(
                        question.getExplanation())
                .lessonCompleted(lessonCompleted)
                .build();
    }
    
}
