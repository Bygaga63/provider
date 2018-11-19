/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.interfaces.JpaObject;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.JpaUser;

import javax.persistence.*;

/**
 *
 * @author root
 */
@Entity
@Table(name = "person_group",
        uniqueConstraints = {@UniqueConstraint(columnNames={"person_id", "group_id"})})
public class JpaUserGroup implements UserGroup, JpaObject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long entityId;
    
    @ManyToOne(targetEntity=JpaUser.class, optional=false)
    @JoinColumn(name="person_id")
    private User user;
    
    @ManyToOne(targetEntity=JpaGroupSocial.class, optional=false)
    @JoinColumn(name="group_id")
    private GroupSocial group;
    
    @Basic
    @Column(name = "roles", nullable = false)
    protected PersonGroupRole role = PersonGroupRole.User;
    
    public JpaUserGroup() {
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
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public GroupSocial getGroup() {
        return group;
    }

    @Override
    public void setGroup(GroupSocial group) {
        this.group = group;
    }

    @Override
    public PersonGroupRole getRole() {
        return this.role;
    }

    @Override
    public void setRole(PersonGroupRole v) {
        this.role = v;
    }

}
