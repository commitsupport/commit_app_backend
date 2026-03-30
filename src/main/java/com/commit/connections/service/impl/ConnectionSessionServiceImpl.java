package com.commit.connections.service.impl;

import com.commit.connections.repository.ConnectionSessionRepository;
import com.commit.connections.service.ConnectionSessionService;
import org.springframework.stereotype.Service;

@Service
public class ConnectionSessionServiceImpl implements ConnectionSessionService {

    private final ConnectionSessionRepository connectionSessionRepository;

    public ConnectionSessionServiceImpl(ConnectionSessionRepository connectionSessionRepository) {
        this.connectionSessionRepository = connectionSessionRepository;
    }

    @Override
    public int closeExpiredSession() {
        return connectionSessionRepository.closeExpiredSessions();
    }
}
