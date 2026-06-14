package com.techlingo.modules.gamification.service;

import com.techlingo.modules.user.entity.UserStats;

public interface XpService {
    void awardXp(
            UserStats userStats,
            int xp
    );
}
