package com.commit.connections.service.impl;

import com.commit.connections.dto.connections.ConnectionDetailsResponse;
import com.commit.connections.dto.connections.ConnectionsResponse;
import com.commit.connections.dto.connections.dto.ConnectionDtlDTO;
import com.commit.connections.dto.connections.dto.ConnectionHdrDTO;
import com.commit.connections.entity.ConnectionDtl;
import com.commit.connections.entity.ConnectionHdr;
import com.commit.connections.repository.ConnectionDtlRepository;
import com.commit.connections.repository.ConnectionHdrRepository;
import com.commit.connections.service.ConnectionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionsServicesImpl implements ConnectionsService {

    private ConnectionHdrRepository connectionHdrRepository;
    private ConnectionDtlRepository connectionDtlRepository;

    public ConnectionsServicesImpl(ConnectionHdrRepository connectionHdrRepository, ConnectionDtlRepository connectionDtlRepository) {
        this.connectionHdrRepository = connectionHdrRepository;
        this.connectionDtlRepository = connectionDtlRepository;
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

    @Override
    public ConnectionDetailsResponse getConnectionDetailsByConhdrid(Integer conhdrid) {

        List<ConnectionDtl> list = connectionDtlRepository.findAllByStatusAndConhdrid("A", conhdrid);
        List<ConnectionDtlDTO> listConnectionsDetails = list.stream()
                .map((d) -> {
                    return new ConnectionDtlDTO(
                            d.getGid(),
                            d.getConhdrid(),
                            d.getName(),
                            d.getHost(),
                            d.getPort(),
                            d.getUserlogin(),
                            d.getPassword(),
                            d.getDescription(),
                            d.getStatus()
                    );
                }).toList();
        ConnectionDetailsResponse response = new ConnectionDetailsResponse(listConnectionsDetails);
        return response;
    }
}
