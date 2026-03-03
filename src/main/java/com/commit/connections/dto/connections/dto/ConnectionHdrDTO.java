package com.commit.connections.dto.connections.dto;

import java.time.Instant;

public class ConnectionHdrDTO {

    private Integer gid;
    private String name;
    private String code;
    private String status;

    public ConnectionHdrDTO(Integer gid, String name, String code, String status) {
        this.gid = gid;
        this.name = name;
        this.code = code;
        this.status = status;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
