package com.commit.connections.dto.connections;

import com.commit.connections.dto.connections.dto.ConnectionDtlDTO;

import java.util.List;

public class ConnectionDetailsResponse {

        private List<ConnectionDtlDTO> listCompanyDetails;

    public ConnectionDetailsResponse(List<ConnectionDtlDTO> listCompanyDetails) {
        this.listCompanyDetails = listCompanyDetails;
    }

    public List<ConnectionDtlDTO> getListCompanyDetails() {
        return listCompanyDetails;
    }

    public void setListCompanyDetails(List<ConnectionDtlDTO> listCompanyDetails) {
        this.listCompanyDetails = listCompanyDetails;
    }
}
