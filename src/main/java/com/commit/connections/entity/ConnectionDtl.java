package com.commit.connections.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "commit_connectiondtl")
public class ConnectionDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private Integer gid;

    @Column(name = "conhdrid")
    private Integer conhdrid;

    @Column(name = "name")
    private String name;

    @Column(name = "host")
    private String host;

    @Column(name = "port")
    private String port;

    @Column(name = "userlogin")
    private String userlogin;

    @Column(name = "password")
    private String password;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "insusrid")
    private Integer insusrid;

    @Column(name = "insstmp")
    private Instant insstmp;

    @Column(name = "updusrid")
    private Integer updusrid;

    @Column(name = "updstmp")
    private Instant updstmp;

    public ConnectionDtl() {
    }

    public ConnectionDtl(Integer gid, Integer conhdrid, String name, String host, String port, String userlogin, String password, String description, String status, Integer insusrid, Instant insstmp, Integer updusrid, Instant updstmp) {
        this.gid = gid;
        this.conhdrid = conhdrid;
        this.name = name;
        this.host = host;
        this.port = port;
        this.userlogin = userlogin;
        this.password = password;
        this.description = description;
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
