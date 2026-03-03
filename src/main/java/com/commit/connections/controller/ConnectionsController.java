package com.commit.connections.controller;

import com.commit.connections.dto.ApiResponse;
import com.commit.connections.dto.connections.ConnectionsResponse;
import com.commit.connections.service.ConnectionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/connections")
public class ConnectionsController {

    public ConnectionsService connectionsService;

    public ConnectionsController(ConnectionsService connectionsService) {
        this.connectionsService = connectionsService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<ConnectionsResponse>> getConnections() {
        ConnectionsResponse response = connectionsService.getAllCompaniesByStatus("A");
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }
}
