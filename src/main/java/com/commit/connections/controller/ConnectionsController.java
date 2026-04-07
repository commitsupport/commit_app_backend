package com.commit.connections.controller;

import com.commit.connections.dto.ApiResponse;
import com.commit.connections.dto.common.RequestContext;
import com.commit.connections.dto.connections.ConnectionDetailsResponse;
import com.commit.connections.dto.connections.ConnectionSingleDetailsRequest;
import com.commit.connections.dto.connections.ConnectionSingleDetailsResponse;
import com.commit.connections.dto.connections.ConnectionsResponse;
import com.commit.connections.service.ConnectionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connections")
public class ConnectionsController {

    private final static Logger log = LoggerFactory.getLogger(ConnectionsController.class);
    public ConnectionsService connectionsService;

    public ConnectionsController(ConnectionsService connectionsService) {
        this.connectionsService = connectionsService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<ConnectionsResponse>> getConnections() {
        log.info("getConnections() for userId={}", RequestContext.get().getUserId());
        ConnectionsResponse response = connectionsService.getAllCompaniesByStatus("A");
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }

    @GetMapping("/details")
    public ResponseEntity<ApiResponse<ConnectionDetailsResponse>> getConnectionDetails(
            @RequestParam("conhdrid") Integer conhdrid
    ) {
        log.info("getConnectionDetails() for userId={}", RequestContext.get().getUserId());
        ConnectionDetailsResponse response = connectionsService.getConnectionDetailsByConhdrid(conhdrid);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }

    @PostMapping("/singledetails")
    public ResponseEntity<ApiResponse<ConnectionSingleDetailsResponse>> updateSingleDetails(
            @RequestBody ConnectionSingleDetailsRequest request
    ) {
        log.info("updateSingleDetails() for userId={}", RequestContext.get().getUserId());
        ConnectionSingleDetailsResponse response = connectionsService.updateSingleDetails(request);
        return ResponseEntity
                .ok(ApiResponse.ok(response));
    }
}
