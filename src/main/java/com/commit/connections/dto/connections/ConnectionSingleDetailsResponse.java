package com.commit.connections.dto.connections;

import com.commit.connections.dto.connections.dto.ConnectionDtlDTO;

public class ConnectionSingleDetailsResponse {

    private String message;
    private ConnectionDtlDTO connectionDtlDTO;

    public ConnectionSingleDetailsResponse(String message, ConnectionDtlDTO connectionDtlDTO) {
        this.message = message;
        this.connectionDtlDTO = connectionDtlDTO;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ConnectionDtlDTO getConnectionDtlDTO() {
        return connectionDtlDTO;
    }

    public void setConnectionDtlDTO(ConnectionDtlDTO connectionDtlDTO) {
        this.connectionDtlDTO = connectionDtlDTO;
    }
}
