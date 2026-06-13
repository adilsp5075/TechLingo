package com.techlingo.modules.learning.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.techlingo.modules.learning.enums.Difficulty;
import com.techlingo.modules.learning.enums.QuestionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "questions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private String id;
    @Indexed
    private String lessonId;
    private QuestionType type;
    private Difficulty difficulty;
    private String title;
    private String description;
    private List<String> options;
    private String correctAnswer;
    private String explanation;
    private Integer xpReward;
}
