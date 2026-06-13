package com.techlingo.modules.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlingo.modules.auth.dto.MessageResponse;
import com.techlingo.modules.user.dto.UpdateAvatarRequest;
import com.techlingo.modules.user.dto.UserProfileResponse;
import com.techlingo.modules.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getProfile")
    public ResponseEntity<UserProfileResponse> getProfile() {
        return ResponseEntity.ok(
                userService.getProfile()
        );
    }

    @PutMapping("/updateAvatar")
    public ResponseEntity<MessageResponse> updateAvatar(@Valid @RequestBody UpdateAvatarRequest request) {
        userService.updateAvatar(request);
        return ResponseEntity.ok(
                new MessageResponse("Avatar updated successfully")
        );
    }
    
}
