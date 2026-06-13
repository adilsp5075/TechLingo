package com.techlingo.modules.learning.dto;

import java.util.List;

import com.techlingo.modules.learning.enums.Difficulty;
import com.techlingo.modules.learning.enums.QuestionType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuestionResponse {
    private String id;
    private QuestionType type;
    private Difficulty difficulty;
    private String title;
    private String description;
    private List<String> options;
    private Integer xpReward;
}
