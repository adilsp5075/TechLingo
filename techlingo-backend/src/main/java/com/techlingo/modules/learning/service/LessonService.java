package com.techlingo.modules.learning.service;

import java.util.List;
import com.techlingo.modules.learning.dto.LessonResponse;

public interface LessonService {
    List<LessonResponse> getLessonsByCourse(String courseId);
    LessonResponse getLesson(String lessonId);

}
