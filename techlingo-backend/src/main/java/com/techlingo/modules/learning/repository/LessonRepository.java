package com.techlingo.modules.learning.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.learning.entity.Lesson;

public interface LessonRepository extends MongoRepository<Lesson, String> {
    List<Lesson> findByCourseIdOrderByLessonOrder(String courseId);
}
