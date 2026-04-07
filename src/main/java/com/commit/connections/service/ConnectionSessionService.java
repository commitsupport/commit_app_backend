package com.commit.connections.service;

import com.commit.connections.dto.connection_session.ConnectionSessionRequest;
import com.commit.connections.dto.connection_session.ConnectionSessionResponse;
import org.springframework.stereotype.Service;

@Service
public interface ConnectionSessionService {

    int closeExpiredSession();
    ConnectionSessionResponse startSession(ConnectionSessionRequest request);
    ConnectionSessionResponse heartbeat(Integer sessionId);
    ConnectionSessionResponse closeSession(Integer sessionId);
}
