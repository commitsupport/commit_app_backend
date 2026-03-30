package com.commit.connections.controller;

import com.commit.connections.dto.ApiResponse;
import com.commit.connections.dto.connections.ConnectionDetailsResponse;
import com.commit.connections.dto.connections.ConnectionSingleDetailsRequest;
import com.commit.connections.dto.connections.ConnectionSingleDetailsResponse;
import com.commit.connections.dto.connections.ConnectionsResponse;
import com.commit.connections.service.ConnectionsService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/details")
    public ResponseEntity<ApiResponse<ConnectionDetailsResponse>> getConnectionDetails(
            @RequestParam("conhdrid") Integer conhdrid
    ) {
        ConnectionDetailsResponse response = connectionsService.getConnectionDetailsByConhdrid(conhdrid);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }

    @PostMapping("/singledetails")
    public ResponseEntity<ApiResponse<ConnectionSingleDetailsResponse>> updateSingleDetails(
            @RequestBody ConnectionSingleDetailsRequest request
    ) {
        ConnectionSingleDetailsResponse response = connectionsService.updateSingleDetails(request);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }
}
