package com.commit.connections.dto.connections.dto;

import jakarta.persistence.Column;

public class ConnectionDtlDTO {

    private Integer gid;
    private Integer conhdrid;
    private String name;
    private String host;
    private String port;
    private String userlogin;
    private String password;
    private String description;
    private String status;

    public ConnectionDtlDTO(Integer gid, Integer conhdrid, String name, String host, String port, String userlogin, String password, String description, String status) {
        this.gid = gid;
        this.conhdrid = conhdrid;
        this.name = name;
        this.host = host;
        this.port = port;
        this.userlogin = userlogin;
        this.password = password;
        this.description = description;
        this.status = status;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getConhdrid() {
        return conhdrid;
    }

    public void setConhdrid(Integer conhdrid) {
        this.conhdrid = conhdrid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
