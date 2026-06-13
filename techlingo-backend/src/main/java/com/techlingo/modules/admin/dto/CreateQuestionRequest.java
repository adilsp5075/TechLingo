package com.techlingo.modules.admin.dto;

import java.util.List;

import com.techlingo.modules.learning.enums.Difficulty;
import com.techlingo.modules.learning.enums.QuestionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQuestionRequest {
    @NotBlank
    private String lessonId;

    @NotNull
    private QuestionType type;

    @NotNull
    private Difficulty difficulty;

    @NotBlank
    private String title;

    private String description;

    private List<String> options;

    @NotBlank
    private String correctAnswer;

    private String explanation;

    @NotNull
    private Integer xpReward;
}
