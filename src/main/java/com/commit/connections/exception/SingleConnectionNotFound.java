package com.commit.connections.exception;

public class SingleConnectionNotFound extends RuntimeException {

    private final ErrorCode code = ErrorCode.SINGLE_CONNECTION_NOT_FOUND;
    private final String details;

    public SingleConnectionNotFound(String message, String details) {
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
