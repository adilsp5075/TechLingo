package com.techlingo.modules.learning.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.learning.entity.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findByLessonId(String lessonId);

    long countByLessonId(String lessonId);
}
