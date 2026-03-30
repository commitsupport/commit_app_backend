package com.commit.connections.scheduler;

import com.commit.connections.service.ConnectionSessionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConnectionSessionScheduler {

    private final ConnectionSessionService connectionSessionService;

    public ConnectionSessionScheduler(ConnectionSessionService connectionSessionService) {
        this.connectionSessionService = connectionSessionService;
    }

    @Scheduled(fixedDelay = 30000)
    public void closeExpiredSession() {
        int updated = connectionSessionService.closeExpiredSession();

        System.out.println("Close expired connection sessions: " + updated);
    }
}
