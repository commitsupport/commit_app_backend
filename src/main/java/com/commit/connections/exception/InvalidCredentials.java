package com.commit.connections.exception;

public class InvalidCredentials extends RuntimeException {

    private final ErrorCode code = ErrorCode.INVALID_CREDENTIALS;
    private final String details;

    public InvalidCredentials(String message, String details) {
        super(message);
        this.details = details;
    }

    public ErrorCode getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }
}
