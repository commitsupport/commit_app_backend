package com.commit.connections.dto.connection_session;

public class ConnectionSessionRequest {

    private Integer condtlid;

    public ConnectionSessionRequest(Integer condtlid) {
        this.condtlid = condtlid;
    }

    public Integer getCondtlid() {
        return condtlid;
    }

    public void setCondtlid(Integer condtlid) {
        this.condtlid = condtlid;
    }

    @Override
    public String toString() {
        return "ConnectionSessionRequest{" +
                "condtlid=" + condtlid +
                '}';
    }
}
