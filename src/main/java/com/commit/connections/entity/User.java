package com.commit.connections.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "commit_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private Integer gid;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

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

    public User() {
    }

    public User(Integer gid, String name, String login, String password, String status, Integer insusrid, Instant insstmp, Integer updusrid, Instant updstmp) {
        this.gid = gid;
        this.name = name;
        this.login = login;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
