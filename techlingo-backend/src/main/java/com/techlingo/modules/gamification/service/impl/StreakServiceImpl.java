package com.techlingo.modules.gamification.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.techlingo.modules.gamification.service.StreakService;
import com.techlingo.modules.user.entity.UserStats;
import com.techlingo.modules.user.repository.UserStatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StreakServiceImpl implements StreakService{

    private final UserStatsRepository userStatsRepository;

    @Override
    public void updateStreak(UserStats stats) {
        LocalDate today = LocalDate.now();
        if (stats.getLastActiveDate() == null) {
            stats.setStreakCount(1);
        } else {
            LocalDate lastActive = stats.getLastActiveDate();
            if (lastActive.plusDays(1).isEqual(today)) {
                stats.setStreakCount(stats.getStreakCount() + 1);
            } else if (!lastActive.isEqual(today)) {
                stats.setStreakCount(1);
            }
        }
        stats.setLastActiveDate(today);
        userStatsRepository.save(stats);
    }
    
}
