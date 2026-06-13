package com.techlingo.modules.admin.service;

import com.techlingo.modules.admin.dto.CreateLessonRequest;
import com.techlingo.modules.learning.entity.Lesson;

public interface AdminLessonService {
    Lesson createLesson(CreateLessonRequest request);
}
