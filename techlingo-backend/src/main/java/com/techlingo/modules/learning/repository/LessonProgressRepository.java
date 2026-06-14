package com.techlingo.modules.learning.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.learning.entity.LessonProgress;

public interface LessonProgressRepository extends MongoRepository<LessonProgress, String> {
    Optional<LessonProgress> findByUserIdAndLessonId(
            String userId,
            String lessonId
    );

    List<LessonProgress> findByUserId(String userId);
    
}
