package com.commit.connections.repository;

import com.commit.connections.entity.ConnectionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ConnectionSessionRepository extends JpaRepository<ConnectionSession, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
            UPDATE commit_connectionsession
            SET
                status = 'T',
                endstmp = now(),
                endlog = 'Heartbeat timeout',
                updstmp = now(),
                updusrid = 0
            WHERE status = 'A'
                AND lasthbstmp < now() - interval '45 second'
            """, nativeQuery = true)
    int closeExpiredSessions();
}
