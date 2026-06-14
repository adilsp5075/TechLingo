package com.techlingo.modules.gamification.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LeaderboardResponse {
    
    private String userId;

    private long xp;

    private int level;
}
