package com.commit.connections.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "commit_usersession")
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private Integer gid;

    @Column(name = "usrid")
    private Integer usrid;

    @Column(name = "token")
    private String token;

    @Column(name = "status")
    private String status;

    @Column(name = "insusrid")
    private Integer insusrid;

    @Column(name = "insstmp", nullable = false, insertable = false, updatable = false)
    private Instant insstmp;

    @Column(name = "updusrid")
    private Integer updusrid;

    @Column(name = "updstmp", nullable = false, insertable = false, updatable = false)
    private Instant updstmp;

    public UserSession() {
    }

    public UserSession(Integer gid, Integer usrid, String token, String status, Integer insusrid, Instant insstmp, Integer updusrid, Instant updstmp) {
        this.gid = gid;
        this.usrid = usrid;
        this.token = token;
        this.status = status;
        this.insusrid = insusrid;
        this.insstmp = insstmp;
        this.updusrid = updusrid;
        this.updstmp = updstmp;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUsrid() {
        return usrid;
    }

    public void setUsrid(Integer usrid) {
        this.usrid = usrid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInsusrid() {
        return insusrid;
    }

    public void setInsusrid(Integer insusrid) {
        this.insusrid = insusrid;
    }

    public Instant getInsstmp() {
        return insstmp;
    }

    public void setInsstmp(Instant insstmp) {
        this.insstmp = insstmp;
    }

    public Integer getUpdusrid() {
        return updusrid;
    }

    public void setUpdusrid(Integer updusrid) {
        this.updusrid = updusrid;
    }

    public Instant getUpdstmp() {
        return updstmp;
    }

    public void setUpdstmp(Instant updstmp) {
        this.updstmp = updstmp;
    }
}
