package com.commit.connections.service.impl;

import com.commit.connections.dto.common.RequestContext;
import com.commit.connections.dto.connection_session.ConnectionSessionRequest;
import com.commit.connections.dto.connection_session.ConnectionSessionResponse;
import com.commit.connections.entity.ConnectionDtl;
import com.commit.connections.entity.ConnectionSession;
import com.commit.connections.repository.ConnectionDtlRepository;
import com.commit.connections.repository.ConnectionSessionRepository;
import com.commit.connections.service.ConnectionSessionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ConnectionSessionServiceImpl implements ConnectionSessionService {

    private static final String STATUS_ACTIVE = "A";
    private static final String STATUS_PENDING = "P";
    private static final String STATUS_CLOSEBY_NEW = "X";
    private static final String STATUS_HEARTBEAT_TIMEOUT = "T";
    private static final String STATUS_CLOSE = "C";

    private final ConnectionSessionRepository connectionSessionRepository;
    private final ConnectionDtlRepository connectionDtlRepository;

    public ConnectionSessionServiceImpl(ConnectionSessionRepository connectionSessionRepository, ConnectionDtlRepository connectionDtlRepository) {
        this.connectionSessionRepository = connectionSessionRepository;
        this.connectionDtlRepository = connectionDtlRepository;
    }

    @Override
    public int closeExpiredSession() {
        return connectionSessionRepository.closeExpiredSessions(STATUS_HEARTBEAT_TIMEOUT, List.of(STATUS_ACTIVE,STATUS_PENDING));
    }

    @Override
    @Transactional
    public ConnectionSessionResponse startSession(ConnectionSessionRequest request) {

        if (request == null || request.getCondtlid() == null) {
            System.out.println("condtlid is required");
            throw new IllegalArgumentException("condtlid is required");
        }

        // zapisanie danych do zmienych
        Integer condtlid = request.getCondtlid();
        Integer userId = RequestContext.get().getUserId();
        Instant now = Instant.now();

        // TODO
        // sprawdzenie czy istnieje podany condtlid
        // jak nie: błąd 404
        ConnectionDtl connectionDtl = connectionDtlRepository.findByGidAndStatus(condtlid, "A");
        if (connectionDtl == null) {
            System.out.println("Start sessji do połączenia którego nie ma w bazie");
            throw new IllegalArgumentException("ConnectionDtl not found or inactive for condtlid=" + condtlid);
            // Zwrócić błąd
        }

        // TODO
        // sprawdzenie czy istnie aktywna sesja na condtlid
        // jesli tak to zamknięcie, status "X"
        // endLog "Closed because new session was started"
//        ConnectionSession existsSession = connectionSessionRepository.findByCondtlidAndStatus(condtlid, "A");
//        if (existsSession != null) {
//            // TODO
//            // zmiana statusu na "X"
//            existsSession.setStatus(STATUS_CLOSEBY_NEW);
//            existsSession.setEndlog("Closed because new session was started");
//            existsSession.setEndstmp(now);
//            existsSession.setUpdusrid(userId);
//            existsSession.setUpdstmp(now);
//
//            connectionSessionRepository.save(existsSession);
//        }

        // TODO
        // insert do connectionSession
        ConnectionSession newSession = new ConnectionSession();
        newSession.setCondtlid(condtlid);
        newSession.setUsrid(userId);
        newSession.setStartstmp(now);
        newSession.setStatus(STATUS_PENDING);
        newSession.setLasthbstmp(now);
        newSession.setInsusrid(userId);
        newSession.setInsstmp(now);
        newSession.setUpdusrid(userId);
        newSession.setUpdstmp(now);

        ConnectionSession savedSession = connectionSessionRepository.save(newSession);

        // TODO
        // Stworzenie obiektu Response na podstawie inserta
        ConnectionSessionResponse response = new ConnectionSessionResponse(
                "Start session",
                savedSession.getGid(),
                savedSession.getCondtlid(),
                savedSession.getStatus(),
                savedSession.getStartstmp()
        );

        // TODO
        // return RESPONSE
        return response;
    }

    @Override
    public ConnectionSessionResponse heartbeat(Integer sessionId) {

        Integer userId = RequestContext.get().getUserId();
        Instant now = Instant.now();

        // TODO
        // sprawdzenie czy istnieje aktywna podana sesja
        // sessionId / status = 'A' / userID
        // jeśli nie, zwróć błąd
        ConnectionSession session =
                connectionSessionRepository.findSessionForUserAndStatuses(sessionId, List.of(STATUS_ACTIVE, STATUS_PENDING), userId);
        if (session == null) {
            throw new IllegalArgumentException("Active session not found for sessionId=" + sessionId);
        }

        // TODO
        // jeśli istnieje sesja zaktualizuj lasthbstmp = now()
        if (session.getStatus().equals(STATUS_ACTIVE)) {
            session.setLasthbstmp(now);
            session.setUpdusrid(userId);
            session.setUpdstmp(now);
        }
        if (session.getStatus().equals(STATUS_PENDING)) {
            session.setLasthbstmp(now);
            session.setUpdusrid(userId);
            session.setUpdstmp(now);
            session.setStatus(STATUS_ACTIVE);
        }

        ConnectionSession savedSession = connectionSessionRepository.save(session);

        // TODO
        // stworzenie obiektu RESPONSE
        ConnectionSessionResponse response = new ConnectionSessionResponse(
                "Heartbeat updated",
                savedSession.getGid(),
                savedSession.getCondtlid(),
                savedSession.getStatus(),
                savedSession.getStartstmp()
        );

        // TODO
        // zwracamy response
        return response;
    }

    @Override
    public ConnectionSessionResponse closeSession(Integer sessionId) {

        Integer userId = RequestContext.get().getUserId();
        Instant now = Instant.now();

        // TODO
        // sprawdzenie czy istnieje aktywna podana sesja
        // sessionId / status = 'A' / userID
        // jeśli nie, zwróć błąd
        ConnectionSession session =
                connectionSessionRepository.findSessionForUserAndStatuses(sessionId, List.of(STATUS_ACTIVE,STATUS_PENDING), userId);
        if (session == null) {
            throw new IllegalArgumentException("Active session not found for sessionId=" + sessionId);
        }

        // TODO
        // zamykamy sesje jeśli istnieje
        session.setEndstmp(now);
        session.setStatus(STATUS_CLOSE);
        session.setEndlog("Session closed");
        session.setUpdusrid(userId);
        session.setUpdstmp(now);

        ConnectionSession savedSession = connectionSessionRepository.save(session);

        // TODO
        // stworzenie obiektu RESPONSE
        ConnectionSessionResponse response = new ConnectionSessionResponse(
                "Session closed",
                savedSession.getGid(),
                savedSession.getCondtlid(),
                savedSession.getStatus(),
                savedSession.getStartstmp()
        );

        return response;
    }


}
