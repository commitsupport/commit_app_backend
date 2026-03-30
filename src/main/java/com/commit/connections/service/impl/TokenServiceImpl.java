package com.commit.connections.service.impl;

import com.commit.connections.entity.UserSession;
import com.commit.connections.repository.UserSessionRepository;
import com.commit.connections.security.TokenSession;
import com.commit.connections.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    UserSessionRepository userSessionRepository;

    public TokenServiceImpl(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    @Override
    public boolean isValid(String token) {
        String hashToken = TokenSession.hashToken(token);

        UserSession userSession = userSessionRepository.findByTokenAndStatus(hashToken,"A");

        return userSession != null;
    }

    @Override
    public UserSession getActiveSession(String token) {
        String hashToken = TokenSession.hashToken(token);
        return userSessionRepository.findByTokenAndStatus(hashToken, "A");
    }
}
