package com.techlingo.infrastructure.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.techlingo.modules.user.entity.User;
import com.techlingo.modules.user.enums.UserRole;
import com.techlingo.modules.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findByEmail("admin@techlingo.com").isEmpty()) {

            User admin = User.builder()
                    .email("admin@techlingo.com")
                    .password(passwordEncoder.encode("admin123"))
                    .role(UserRole.ROLE_ADMIN)
                    .build();

            userRepository.save(admin);
        }
    }
}
