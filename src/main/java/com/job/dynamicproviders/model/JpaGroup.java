package com.job.dynamicproviders.model;

import com.job.dynamicproviders.interfaces.Group;
import com.job.dynamicproviders.interfaces.JpaObject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class JpaGroup implements Group, JpaObject {

    @Id
    @Column(name = "entity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    @Version
    private Long version;

    @Basic
    @Column(name = "limit_num", nullable = false)
    private Integer limit = -1;

    @Basic
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Basic
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
}