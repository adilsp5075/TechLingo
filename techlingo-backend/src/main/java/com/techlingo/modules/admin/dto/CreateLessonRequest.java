package com.techlingo.modules.admin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLessonRequest {
    @NotBlank
    private String courseId;
    
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private Integer lessonOrder;

    @NotNull
    private Integer xpReward;
}
