package com.job.dynamicproviders.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties({"type", "limit", "enabled", "parents", "children"})
public interface GroupSocial extends GroupOwner{
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    GroupType getType();
    void setType(GroupType type);
    List<GroupSocial> getParents();
    List<GroupSocial> getChildren();

}