package com.commit.connections.service.impl;

import com.commit.connections.dto.common.RequestContext;
import com.commit.connections.dto.connections.ConnectionDetailsResponse;
import com.commit.connections.dto.connections.ConnectionSingleDetailsRequest;
import com.commit.connections.dto.connections.ConnectionSingleDetailsResponse;
import com.commit.connections.dto.connections.ConnectionsResponse;
import com.commit.connections.dto.connections.dto.ConnectionDtlDTO;
import com.commit.connections.dto.connections.dto.ConnectionHdrDTO;
import com.commit.connections.entity.ConnectionDtl;
import com.commit.connections.entity.ConnectionHdr;
import com.commit.connections.exception.SingleConnectionNotFound;
import com.commit.connections.repository.ConnectionDtlRepository;
import com.commit.connections.repository.ConnectionHdrRepository;
import com.commit.connections.service.ConnectionsService;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    @Override
    public ConnectionSingleDetailsResponse updateSingleDetails(ConnectionSingleDetailsRequest request) {

        // sprawdzenie czy istnieje takie połączenie do serwera po gid i conhdrid
        ConnectionDtl connectionDtl = connectionDtlRepository
                .findAllByGidAndStatusAndConhdrid(request.getGid(), request.getStatus(), request.getConhdrid());
        if (connectionDtl == null) {
            throw new SingleConnectionNotFound(
                    "Nie znaleziono połączenie wpisu do aktualizacji",
                    "Not found record: gid: " + request.getGid() + ", status: " + request.getStatus() + ", conhdrid: " + request.getConhdrid()
            );
        }

        // update wszystkich pól które zostały podane - jak nie podane to nić nie nie zmieniać
        if (request.getName() != null) connectionDtl.setName(request.getName());
        if (request.getHost() != null) connectionDtl.setHost(request.getHost());
        if (request.getPort() != null) connectionDtl.setPort(request.getPort());
        if (request.getUserlogin() != null) connectionDtl.setUserlogin((request.getUserlogin()));
        if (request.getPassword() != null) connectionDtl.setPassword(request.getPassword());
        if (request.getDescription() != null) connectionDtl.setDescription(request.getDescription());
        if (request.getStatus() != null) connectionDtl.setStatus(request.getStatus());
        connectionDtl.setUpdstmp(Instant.now());
        connectionDtl.setUpdusrid(RequestContext.get().getUserId());


        ConnectionDtl connectionDtlUpdated = connectionDtlRepository.save(connectionDtl);

        // zwrócenie response
        return new ConnectionSingleDetailsResponse(
                "success update",
                new ConnectionDtlDTO(
                        connectionDtlUpdated.getGid(),
                        connectionDtlUpdated.getConhdrid(),
                        connectionDtlUpdated.getName(),
                        connectionDtlUpdated.getHost(),
                        connectionDtlUpdated.getPort(),
                        connectionDtlUpdated.getUserlogin(),
                        connectionDtlUpdated.getPassword(),
                        connectionDtlUpdated.getDescription(),
                        connectionDtlUpdated.getStatus()
                )
        );
    }
}
