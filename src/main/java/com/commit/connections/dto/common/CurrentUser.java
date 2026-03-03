package com.commit.connections.dto.common;

public class CurrentUser {

    private final Integer userId;
    private final String token;

    public CurrentUser(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }
}
