package com.job.dynamicproviders.model;

import com.job.dynamicproviders.interfaces.JpaObject;
import com.job.dynamicproviders.interfaces.User;

import javax.persistence.*;

@Entity
@Table(name="person")
@DiscriminatorValue("AbstractUser")
public abstract class JpaAbstractUser implements User, JpaObject {
    @Id
    @Column(name = "entity_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long entityId;

    @Override
    public Long getEntityId() {
        return entityId;
    }

    @Override
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

}