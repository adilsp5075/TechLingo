package com.techlingo.modules.submission.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubmissionResponse {
    
    private boolean correct;

    private String explanation;

    private int xpEarned;

    private int remainingLives;

    private boolean lessonCompleted;
}
