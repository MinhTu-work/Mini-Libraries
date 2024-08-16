package com.example.Client.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Time;
import java.util.Date;

abstract class BaseEntity{
    @CreationTimestamp
    @Temporal(TemporalType.TIME)
    @Column(name = "createDate")
    private Time createTime;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "modifiedDate")
    private Date modifiedDate;

    @Column(name = "createBy")
    private String createBy;

    @Column(name = "modifiedBy")
    private String modifiedBy;
}
