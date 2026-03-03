package com.commit.connections.dto.auth;

public class LoginResponse {

    private Integer userid;
    private String token;
    private String login;
    private String name;

    public LoginResponse(Integer userid, String token, String login, String name) {
        this.userid = userid;
        this.token = token;
        this.login = login;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
