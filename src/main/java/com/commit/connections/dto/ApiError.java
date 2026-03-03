package com.commit.connections.dto;

import com.commit.connections.exception.ErrorCode;

public class ApiError {

    private int status;
    private ErrorCode code;
    private String message;
    private String details;

    public ApiError(int status, ErrorCode code, String message, String details) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
