package com.commit.connections.service.impl;

import com.commit.connections.dto.connections.ConnectionsResponse;
import com.commit.connections.dto.connections.dto.ConnectionHdrDTO;
import com.commit.connections.entity.ConnectionHdr;
import com.commit.connections.repository.ConnectionHdrRepository;
import com.commit.connections.service.ConnectionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionsServicesImpl implements ConnectionsService {

    private ConnectionHdrRepository connectionHdrRepository;

    public ConnectionsServicesImpl(ConnectionHdrRepository connectionHdrRepository) {
        this.connectionHdrRepository = connectionHdrRepository;
    }

    @Override
    public ConnectionsResponse getAllCompaniesByStatus(String status) {

        List<ConnectionHdr> list = connectionHdrRepository.findAllByStatus("A");
        List<ConnectionHdrDTO> listCompanies = list.stream()
                .map((c) -> {
                    return new ConnectionHdrDTO(
                            c.getGid(),
                            c.getName(),
                            c.getCode(),
                            c.getStatus()
                    );
                }).toList();
        ConnectionsResponse response = new ConnectionsResponse(listCompanies);
        return response;
    }
}
