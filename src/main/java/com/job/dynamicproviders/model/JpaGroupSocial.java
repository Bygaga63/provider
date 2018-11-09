package com.job.dynamicproviders.model;

import com.job.dynamicproviders.interfaces.GroupSocial;
import com.job.dynamicproviders.interfaces.GroupType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_social")
@Data
public class JpaGroupSocial extends JpaGroupOwner implements GroupSocial {

    @Basic
    @Column(name = "name", nullable = false)
    protected String name;

    @Basic
    @Column(name = "description", length = 255)
    protected String description;

    @ManyToOne(targetEntity = JpaGroupType.class)
    @JoinColumn(name = "group_type_id", nullable = false)
    private GroupType type;

    @ManyToMany(targetEntity = JpaGroupSocial.class)
    @JoinTable(
            name = "group_child",
            joinColumns = {
                    @JoinColumn(name = "child_id", referencedColumnName = "entity_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "parent_id", referencedColumnName = "entity_id")})
    List<GroupSocial> parents;

    @ManyToMany(targetEntity = JpaGroupSocial.class, mappedBy = "parents")
    List<GroupSocial> children;

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}