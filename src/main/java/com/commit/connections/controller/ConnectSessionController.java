package com.commit.connections.controller;

import com.commit.connections.dto.ApiResponse;
import com.commit.connections.dto.connection_session.ConnectionSessionRequest;
import com.commit.connections.dto.connection_session.ConnectionSessionResponse;
import com.commit.connections.service.ConnectionSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connect-session")
public class ConnectSessionController {

    ConnectionSessionService connectionSessionService;

    public ConnectSessionController(ConnectionSessionService connectionSessionService) {
        this.connectionSessionService = connectionSessionService;
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<ConnectionSessionResponse>> startSession(
            @RequestBody ConnectionSessionRequest request
    ) {
        ConnectionSessionResponse response = connectionSessionService.startSession(request);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }

    @PostMapping("{sessionId}/heartbeat")
    public ResponseEntity<ApiResponse<ConnectionSessionResponse>> heartbeat(
            @PathVariable Integer sessionId
    ) {
        ConnectionSessionResponse response = connectionSessionService.heartbeat(sessionId);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }

    @PostMapping("{sessionId}/close")
    public ResponseEntity<ApiResponse<ConnectionSessionResponse>> closeSession(
            @PathVariable Integer sessionId
    ) {
        ConnectionSessionResponse response = connectionSessionService.closeSession(sessionId);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }
}
