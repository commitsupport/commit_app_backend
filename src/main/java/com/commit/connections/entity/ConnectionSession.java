package com.commit.connections.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "commit_connectionsession")
public class ConnectionSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gid")
    private Integer gid;

    @Column(name = "condtlid")
    private Integer condtlid;

    @Column(name = "usrid")
    private Integer usrid;

    @Column(name = "startstmp")
    private Instant startstmp;

    @Column(name = "lasthbstmp")
    private Instant lasthbstmp;

    @Column(name = "endstmp")
    private Instant endstmp;

    @Column(name = "status")
    private String status;

    @Column(name = "endlog")
    private String endlog;

    @Column(name = "insusrid")
    private Integer insusrid;

    @Column(name = "insstmp")
    private Instant insstmp;

    @Column(name = "updusrid")
    private Integer updusrid;

    @Column(name = "updstmp")
    private Instant updstmp;

    public ConnectionSession() {
    }

    public ConnectionSession(Integer insusrid, Integer gid, Integer condtlid, Integer usrid, Instant startstmp, Instant lasthbstmp, Instant endstmp, String status, String endlog, Instant insstmp, Integer updusrid, Instant updstmp) {
        this.insusrid = insusrid;
        this.gid = gid;
        this.condtlid = condtlid;
        this.usrid = usrid;
        this.startstmp = startstmp;
        this.lasthbstmp = lasthbstmp;
        this.endstmp = endstmp;
        this.status = status;
        this.endlog = endlog;
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

    public Integer getCondtlid() {
        return condtlid;
    }

    public void setCondtlid(Integer condtlid) {
        this.condtlid = condtlid;
    }

    public Integer getUsrid() {
        return usrid;
    }

    public void setUsrid(Integer usrid) {
        this.usrid = usrid;
    }

    public Instant getStartstmp() {
        return startstmp;
    }

    public void setStartstmp(Instant startstmp) {
        this.startstmp = startstmp;
    }

    public Instant getLasthbstmp() {
        return lasthbstmp;
    }

    public void setLasthbstmp(Instant lasthbstmp) {
        this.lasthbstmp = lasthbstmp;
    }

    public Instant getEndstmp() {
        return endstmp;
    }

    public void setEndstmp(Instant endstmp) {
        this.endstmp = endstmp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEndlog() {
        return endlog;
    }

    public void setEndlog(String endlog) {
        this.endlog = endlog;
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

    @Override
    public String toString() {
        return "ConnectionSession{" +
                "gid=" + gid +
                ", condtlid=" + condtlid +
                ", usrid=" + usrid +
                ", startstmp=" + startstmp +
                ", lasthbstmp=" + lasthbstmp +
                ", endstmp=" + endstmp +
                ", status='" + status + '\'' +
                ", endlog='" + endlog + '\'' +
                ", insusrid=" + insusrid +
                ", insstmp=" + insstmp +
                ", updusrid=" + updusrid +
                ", updstmp=" + updstmp +
                '}';
    }
}
