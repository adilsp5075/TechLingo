package com.techlingo.modules.learning.service.impl;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.techlingo.common.exception.ResourceNotFoundException;
import com.techlingo.modules.learning.dto.LessonResponse;
import com.techlingo.modules.learning.entity.Lesson;
import com.techlingo.modules.learning.entity.LessonProgress;
import com.techlingo.modules.learning.enums.LessonStatus;
import com.techlingo.modules.learning.repository.LessonProgressRepository;
import com.techlingo.modules.learning.repository.LessonRepository;
import com.techlingo.modules.learning.service.LessonService;
import com.techlingo.modules.user.entity.User;
import com.techlingo.modules.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    
    private final LessonRepository lessonRepository;
    private final LessonProgressRepository lessonProgressRepository;
    private final UserRepository userRepository;
    @Override
    public List<LessonResponse> getLessonsByCourse(String courseId) {
        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return lessonRepository
                .findByCourseIdOrderByLessonOrder(courseId)
                .stream()
                .map(lesson -> buildLessonResponse(user.getId(), lesson))
                .toList();
    }
    @Override
    public LessonResponse getLesson(String lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Lesson not found"));

        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .lessonOrder(lesson.getLessonOrder())
                .xpReward(lesson.getXpReward())
                .status(LessonStatus.IN_PROGRESS)
                .build();
    }

    private LessonResponse buildLessonResponse(
            String userId,
            Lesson lesson) {

        LessonStatus status = lessonProgressRepository
                .findByUserIdAndLessonId(userId, lesson.getId())
                .map(LessonProgress::getStatus)
                .orElse(LessonStatus.LOCKED);

        return LessonResponse.builder()
                .id(lesson.getId())
                .title(lesson.getTitle())
                .description(lesson.getDescription())
                .lessonOrder(lesson.getLessonOrder())
                .xpReward(lesson.getXpReward())
                .status(status)
                .build();
    }
}
