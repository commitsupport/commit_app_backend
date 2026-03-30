package com.commit.connections.repository;

import com.commit.connections.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {

    UserSession findByTokenAndStatus(String token, String status);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE UserSession us SET us.status = 'I' WHERE us.status = 'A' AND us.usrid = :usrid")
    void setStatusInactiveByUserid(
            @Param("usrid") Integer usrid
    );
}
