package com.commit.connections.exception;

public class UserNotFoundException extends RuntimeException{

    private final ErrorCode code = ErrorCode.USER_NOT_FOUND;
    private final String details;

    public UserNotFoundException(String details) {
        super("Nie znaleziono użytkownika");
        this.details = details;
    }

    public ErrorCode getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }
}
