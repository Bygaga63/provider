/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;


import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
@Entity
@Table(name = "group_social")
public class JpaGroupSocial extends JpaGroupOwner implements GroupSocial  {
    
    @Basic
    @Column(name = "name", nullable = false)
    protected String name;

    @Basic
    @Column(name = "description", length = 255)
    protected String description;

    @ManyToOne(targetEntity = JpaGroupType.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_type_id", nullable = false)
    private GroupType type;

    @ManyToMany(targetEntity=JpaGroupSocial.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "group_child",
            joinColumns = {
                @JoinColumn(name = "child_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "parent_id", referencedColumnName = "id")})
    List<GroupSocial> parents;

    @ManyToMany(targetEntity=JpaGroupSocial.class, mappedBy="parents", cascade = CascadeType.ALL)
    List<GroupSocial> children;

    public JpaGroupSocial() {    
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
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
    public GroupType getType() {
        return type;
    }

    @Override
    public void setType(GroupType type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public List<GroupSocial> getParents() {
        return parents;
    }
    
    @Override
    public List<GroupSocial> getChildren() {
        return children;
    }

}
