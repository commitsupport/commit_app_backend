package com.commit.connections.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "commit_connectionhdr")
public class ConnectionHdr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private Integer gid;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

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

    public ConnectionHdr() {
    }

    public ConnectionHdr(Integer gid, String name, String code, String status, Integer insusrid, Instant insstmp, Integer updusrid, Instant updstmp) {
        this.gid = gid;
        this.name = name;
        this.code = code;
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
