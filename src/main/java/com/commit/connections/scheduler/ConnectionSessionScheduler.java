package com.commit.connections.scheduler;

import com.commit.connections.service.ConnectionSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConnectionSessionScheduler {

    private static final Logger log = LoggerFactory.getLogger(ConnectionSessionScheduler.class);
    private final ConnectionSessionService connectionSessionService;

    public ConnectionSessionScheduler(ConnectionSessionService connectionSessionService) {
        this.connectionSessionService = connectionSessionService;
    }

    @Scheduled(fixedDelay = 30000)
    public void closeExpiredSession() {
        int updated = connectionSessionService.closeExpiredSession();

        log.info("Close expired connection sessions: {}", updated);
        System.out.println("Close expired connection sessions: " + updated);
    }
}
