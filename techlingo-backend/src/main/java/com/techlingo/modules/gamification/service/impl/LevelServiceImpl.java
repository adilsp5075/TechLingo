package com.techlingo.modules.gamification.service.impl;

import org.springframework.stereotype.Service;

import com.techlingo.modules.gamification.constants.GamificationConstants;
import com.techlingo.modules.gamification.service.LevelService;
import com.techlingo.modules.user.entity.UserStats;

@Service
public class LevelServiceImpl implements LevelService {
    @Override
    public void calculateLevel(UserStats userStats) {
        int level = (int) (userStats.getXp()
                        / GamificationConstants.XP_PER_LEVEL)
                        + 1;
        userStats.setCurrentLevel(level);
    }
}
