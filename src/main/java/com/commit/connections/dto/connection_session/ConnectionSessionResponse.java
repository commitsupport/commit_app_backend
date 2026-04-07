package com.commit.connections.dto.connection_session;

import java.time.Instant;

public class ConnectionSessionResponse {

    private String message;
    private Integer sessionId;
    private Integer condtlid;
    private String status;
    private Instant startstmp;

    public ConnectionSessionResponse(String message, Integer sessionId, Integer condtlid, String status, Instant startstmp) {
        this.message = message;
        this.sessionId = sessionId;
        this.condtlid = condtlid;
        this.status = status;
        this.startstmp = startstmp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getCondtlid() {
        return condtlid;
    }

    public void setCondtlid(Integer condtlid) {
        this.condtlid = condtlid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getStartstmp() {
        return startstmp;
    }

    public void setStartstmp(Instant startstmp) {
        this.startstmp = startstmp;
    }

    @Override
    public String toString() {
        return "ConnectionSessionResponse{" +
                "message='" + message + '\'' +
                ", sessionId=" + sessionId +
                ", condtlid=" + condtlid +
                ", status='" + status + '\'' +
                ", startstmp=" + startstmp +
                '}';
    }
}
