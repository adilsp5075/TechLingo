package com.techlingo.modules.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProfileResponse {
    private String id;
    private String email;
    private String name;
    private String avatarUrl;
    private long xp;
    private int currentLevel;
    private int streakCount;
    private int lives;
}
