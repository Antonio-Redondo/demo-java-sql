package com.example.demojavasql.model.entity;

import com.example.demojavasql.data.JPAEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by arm on 28/01/2018.
 */
@Entity
@Table(name = "ACCESS")
public class Access extends  JPAEntity<Long>implements Serializable {

    private static final long serialVersionUID = -6470090944414208496L;

    @Id
    @Column(name = "ACCESS_ID", nullable = false)
    private long accessId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTDATE", nullable = false)
    private Date startDate;

    @Transient
    private long repetitions;

    @Column(name = "IP", nullable = false)
    private String ip;



    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getAccessId() {
        return accessId;
    }

    public void setAccessId(long accessId) {
        this.accessId = accessId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public long getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(long repetitions) {
        this.repetitions = repetitions;
    }
}
