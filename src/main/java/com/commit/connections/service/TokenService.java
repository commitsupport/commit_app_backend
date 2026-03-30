package com.commit.connections.service;

import com.commit.connections.entity.UserSession;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    boolean isValid(String token);
    UserSession getActiveSession(String token);
}
