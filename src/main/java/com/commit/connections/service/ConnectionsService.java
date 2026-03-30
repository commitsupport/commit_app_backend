package com.commit.connections.service;

import com.commit.connections.dto.connections.ConnectionDetailsResponse;
import com.commit.connections.dto.connections.ConnectionSingleDetailsRequest;
import com.commit.connections.dto.connections.ConnectionSingleDetailsResponse;
import com.commit.connections.dto.connections.ConnectionsResponse;
import org.springframework.stereotype.Service;

@Service
public interface ConnectionsService {

    ConnectionsResponse getAllCompaniesByStatus(String status);
    ConnectionDetailsResponse getConnectionDetailsByConhdrid(Integer conhdrid);
    ConnectionSingleDetailsResponse updateSingleDetails(ConnectionSingleDetailsRequest request);
}
