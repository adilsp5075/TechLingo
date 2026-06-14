package com.techlingo.modules.gamification.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techlingo.modules.gamification.dto.LeaderboardResponse;
import com.techlingo.modules.gamification.service.LeaderboardService;
import com.techlingo.modules.user.repository.UserStatsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaderboardServiceImpl  implements LeaderboardService{

    private final UserStatsRepository userStatsRepository;


    @Override
    public List<LeaderboardResponse> getTopPlayers() {
        return userStatsRepository
                .findTop10ByOrderByXpDesc()
                .stream()
                .map(stats ->
                        LeaderboardResponse.builder()
                                .userId(stats.getUserId())
                                .xp(stats.getXp())
                                .level(stats.getCurrentLevel())
                                .build())
                .toList();
    }
    
}
