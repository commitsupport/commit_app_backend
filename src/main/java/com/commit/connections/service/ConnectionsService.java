package com.commit.connections.service;

import com.commit.connections.dto.connections.ConnectionsResponse;
import org.springframework.stereotype.Service;

@Service
public interface ConnectionsService {

    ConnectionsResponse getAllCompaniesByStatus(String status);
}
