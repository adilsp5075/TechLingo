package com.techlingo.modules.gamification.service;

import com.techlingo.modules.user.entity.UserStats;

public interface LevelService {
    void calculateLevel(
            UserStats userStats
    );
}
