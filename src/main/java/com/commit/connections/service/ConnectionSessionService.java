package com.commit.connections.service;

import org.springframework.stereotype.Service;

@Service
public interface ConnectionSessionService {

    public int closeExpiredSession();
}
