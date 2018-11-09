/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model;

import com.job.dynamicproviders.interfaces.GroupType;
import com.job.dynamicproviders.interfaces.JpaObject;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Table(name = "group_type")
@Data
@AllArgsConstructor
public class JpaGroupType implements GroupType, JpaObject {
    
    @Id
    @Column(name = "entity_id")
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
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
