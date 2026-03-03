package com.commit.connections.dto.connections;

import com.commit.connections.dto.connections.dto.ConnectionHdrDTO;

import java.util.List;

public class ConnectionsResponse {

    private List<ConnectionHdrDTO> listCompany;

    public ConnectionsResponse(List<ConnectionHdrDTO> listCompany) {
        this.listCompany = listCompany;
    }

    public List<ConnectionHdrDTO> getListCompany() {
        return listCompany;
    }

    public void setListCompany(List<ConnectionHdrDTO> listCompany) {
        this.listCompany = listCompany;
    }
}
