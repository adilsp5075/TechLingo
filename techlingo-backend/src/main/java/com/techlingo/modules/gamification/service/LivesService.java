package com.techlingo.modules.gamification.service;

import com.techlingo.modules.user.entity.UserStats;

public interface LivesService {
    void deductLife(
            UserStats userStats
    );

    boolean hasLives(
            UserStats userStats
    );
}
