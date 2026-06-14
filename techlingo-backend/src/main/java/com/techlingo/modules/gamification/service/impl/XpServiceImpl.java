package com.techlingo.modules.gamification.service.impl;

import org.springframework.stereotype.Service;

import com.techlingo.modules.gamification.service.LevelService;
import com.techlingo.modules.gamification.service.XpService;
import com.techlingo.modules.user.entity.UserStats;
import com.techlingo.modules.user.repository.UserStatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class XpServiceImpl implements XpService{
    private final UserStatsRepository userStatsRepository;

    private final LevelService levelService;

    @Override
    public void awardXp(UserStats userStats, int xp) {
        userStats.setXp(
            userStats.getXp() + xp
        );
        levelService.calculateLevel(userStats);
        userStatsRepository.save(userStats);
    }
    
}
