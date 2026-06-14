package com.techlingo.modules.gamification.service.impl;

import org.springframework.stereotype.Service;

import com.techlingo.modules.gamification.service.LivesService;
import com.techlingo.modules.user.entity.UserStats;
import com.techlingo.modules.user.repository.UserStatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivesServiceImpl implements LivesService {

    private final UserStatsRepository userStatsRepository ;

    @Override
    public void deductLife(UserStats userStats) {
        userStats.setLives(
                Math.max(
                        0,
                        userStats.getLives() - 1
                ));
        userStatsRepository.save(userStats);
    }

    @Override
    public boolean hasLives(UserStats userStats) {
        return userStats.getLives() > 0;
    }

     
    
}
