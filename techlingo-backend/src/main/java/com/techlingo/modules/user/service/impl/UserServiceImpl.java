package com.techlingo.modules.user.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.techlingo.modules.user.dto.UpdateAvatarRequest;
import com.techlingo.modules.user.dto.UserProfileResponse;
import com.techlingo.modules.user.entity.User;
import com.techlingo.modules.user.entity.UserStats;
import com.techlingo.modules.user.repository.UserRepository;
import com.techlingo.modules.user.repository.UserStatsRepository;
import com.techlingo.modules.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserStatsRepository userStatsRepository;

    @Override
    public void updateAvatar(UpdateAvatarRequest request) {
        String email =
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setAvatarUrl(request.getAvatarUrl());
        userRepository.save(user);
    }

    @Override
    public UserProfileResponse getProfile() {
        String email =
                SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
        UserStats stats =
                userStatsRepository.findByUserId(user.getId())
                        .orElseThrow(() ->
                                new RuntimeException("Stats not found"));

        return UserProfileResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .avatarUrl(user.getAvatarUrl())
                .xp(stats.getXp())
                .currentLevel(stats.getCurrentLevel())
                .streakCount(stats.getStreakCount())
                .lives(stats.getLives())
                .build();
    }
}
