package com.job.dynamicproviders.model;

import com.job.dynamicproviders.interfaces.Group;
import com.job.dynamicproviders.interfaces.JpaObject;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class JpaGroup implements Group, JpaObject {

    @Id
    @Column(name = "id")
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


    public JpaGroup() {
        this.created = new Date();
    }

    @Override
    public Long getId() {
        return entityId;
    }

    @Override
    public void setEntityId(Long id) {
        this.entityId = id;
    }

    @Override
    public Long getEntityId() {
        return this.entityId;
    }

    @Override
    public void setId(Long id) {
        this.entityId = id;
    }

    @Override
    public Boolean getEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

}
