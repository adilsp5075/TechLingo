package com.techlingo.modules.gamification.service;

import java.util.List;

import com.techlingo.modules.gamification.dto.LeaderboardResponse;

public interface LeaderboardService {
    List<LeaderboardResponse> getTopPlayers();
}
