package com.commit.connections.service;

import com.commit.connections.dto.auth.LoginRequest;
import com.commit.connections.dto.auth.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
}
