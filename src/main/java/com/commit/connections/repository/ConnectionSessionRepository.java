package com.commit.connections.repository;

import com.commit.connections.dto.connection_session.dto.ConnectionSessionActive;
import com.commit.connections.entity.ConnectionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public interface ConnectionSessionRepository extends JpaRepository<ConnectionSession, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
            UPDATE commit_connectionsession
            SET
                status = :statusEnd,
                endstmp = now(),
                endlog = 'Heartbeat timeout',
                updstmp = now(),
                updusrid = 0
            WHERE status IN :statuses
                AND lasthbstmp < now() - interval '45 second'
            """, nativeQuery = true)
    int closeExpiredSessions(
            @Param("statusEnd") String statusEnd,
            @Param("statuses") java.util.Collection<String> statuses
    );

    @Query(value = """
            SELECT cs FROM ConnectionSession cs
                WHERE cs.gid = :sessionId
                AND cs.status IN :statuses
                AND cs.usrid = :userId
            """)
    ConnectionSession findSessionForUserAndStatuses(
            @Param("sessionId") Integer sessionId,
            @Param("statuses") java.util.Collection<String> statuses,
            @Param("userId") Integer userId
    );

    @Query(value = """
            SELECT
                u.name AS username,
                cd.conhdrid AS conhdrid,
                ch.name as conhdrname,
                cs.condtlid as condtlid,
                cd.name as condtlname
            FROM commit_connectionsession cs
                left JOIN commit_connectiondtl cd ON cd.gid = cs.condtlid
                left JOIN commit_connectionhdr ch ON ch.gid = cd.conhdrid
                left JOIN commit_user u ON u.gid = cs.usrid
                    WHERE 1=1
                    AND cs.status IN (:statuses)
                    AND cd.conhdrid = :conhdrid
            """,
            nativeQuery = true
    )
    List<ConnectionSessionActive> getActiveSessionByConhdridAndStatus(
            @Param("statuses") Collection<String> statuses,
            @Param("conhdrid") Integer conhdrid
    );

    ConnectionSession findByCondtlidAndStatus(Integer condtlid, String status);
}
