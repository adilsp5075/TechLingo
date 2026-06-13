package com.techlingo.modules.learning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.techlingo.modules.learning.entity.Course;

public interface CourseRepository extends MongoRepository<Course, String> {
    
}
