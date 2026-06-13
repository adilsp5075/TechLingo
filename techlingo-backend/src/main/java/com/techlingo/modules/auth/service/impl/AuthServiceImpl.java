package com.techlingo.modules.auth.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techlingo.modules.auth.dto.AuthResponse;
import com.techlingo.modules.auth.dto.LoginRequest;
import com.techlingo.modules.auth.dto.MessageResponse;
import com.techlingo.modules.auth.dto.SignupRequest;
import com.techlingo.modules.auth.service.AuthService;
import com.techlingo.modules.user.entity.User;
import com.techlingo.modules.user.entity.UserStats;
import com.techlingo.modules.user.enums.UserRole;
import com.techlingo.modules.user.repository.UserRepository;
import com.techlingo.modules.user.repository.UserStatsRepository;
import com.techlingo.security.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    private final UserStatsRepository userStatsRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public MessageResponse signup(SignupRequest request) {
        boolean exists = userRepository.findByEmail(request.getEmail()).isPresent();
        if(exists){
            return new MessageResponse("Email already in use");
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.ROLE_USER)
                .name(request.getName())
                .build();

        userRepository.save(user);

        UserStats stats = UserStats.builder()
                    .userId(user.getId())
                    .xp(0)
                    .currentLevel(1)
                    .streakCount(0)
                    .lives(5)
                    .build();

        userStatsRepository.save(stats);
        return new MessageResponse("User registered successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = jwtService.generateToken(request.getEmail());
        return AuthResponse.builder()
                .token(token)
                .email(request.getEmail())
                .build();
    }
    
}
