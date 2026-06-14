package com.techlingo.modules.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.learning.entity.Lesson;

public interface LessonRepository extends MongoRepository<Lesson, String> {
    List<Lesson> findByCourseIdOrderByLessonOrder(String courseId);

    Optional<Lesson> findByCourseIdAndLessonOrder(
        String courseId,
        Integer lessonOrder
);
}
