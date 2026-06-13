package com.techlingo.modules.auth.service;

import com.techlingo.modules.auth.dto.AuthResponse;
import com.techlingo.modules.auth.dto.LoginRequest;
import com.techlingo.modules.auth.dto.MessageResponse;
import com.techlingo.modules.auth.dto.SignupRequest;

public interface AuthService {

    MessageResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
