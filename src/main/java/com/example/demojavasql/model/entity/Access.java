package com.example.demojavasql.model.entity;

import com.example.demojavasql.data.JPAEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by arm on 28/01/2018.
 */
@Entity
@Table(name = "ACCESS")
@Getter
@Setter
@ToString
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


}
