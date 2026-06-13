package com.techlingo.modules.learning.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.techlingo.modules.learning.enums.LessonStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "progress")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LessonProgress {
    @Id
    private String id;
    private String userId;
    private String lessonId;
    private LessonStatus status;
    private Integer score;
}
