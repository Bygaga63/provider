/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.interfaces.JpaObject;
import lombok.Builder;

import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Table(name = "group_type")
public class JpaGroupType implements GroupType, JpaObject {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long entityId;
    
    @Basic
    @Column(name = "name", unique=true, nullable=false)
    protected String name;
    
    @Basic
    @Column(name = "access", nullable = false)
    protected GroupTypeAccess access = GroupTypeAccess.Public;
    
    
    public JpaGroupType() {
    }
    
    
    
    
    @Override
    public Long getId() {
        return entityId;
    }

    @Override
    public void setId(Long id) {
        this.entityId = id;
    }

    
    @Override
    public Long getEntityId() {
        return this.entityId;
    }
    
    @Override
    public void setEntityId(Long id) {
        this.entityId = id;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public GroupTypeAccess getAccess() {
        return this.access;
    }
    
    @Override
    public void setAccess(GroupTypeAccess v) {
        this.access = v;
    }
    
}
