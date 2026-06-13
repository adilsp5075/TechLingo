package com.techlingo.modules.learning.dto;

import com.techlingo.modules.learning.enums.LessonStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LessonResponse {
    private String id;
    private String title;
    private String description;
    private Integer lessonOrder;
    private Integer xpReward;
    private LessonStatus status;
}
