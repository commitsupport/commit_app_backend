package com.commit.connections.controller;

import com.commit.connections.dto.ApiResponse;
import com.commit.connections.dto.auth.LoginRequest;
import com.commit.connections.dto.auth.LoginResponse;
import com.commit.connections.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @RequestBody LoginRequest loginRequest
    ) {
        LoginResponse loginResponse = authService.login(loginRequest);
        return ResponseEntity
                .ok(ApiResponse.ok(loginResponse));
    }
}
