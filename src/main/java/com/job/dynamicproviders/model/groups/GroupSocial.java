/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 *
 * @author root
 */
@JsonIgnoreProperties({"type", "limit", "enabled", "parents", "children"})
public interface GroupSocial extends GroupOwner{
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
//    Integer getLimit();
//    void setLimit(Integer limit);    
//    Boolean getEnabled();
//    void setEnabled(Boolean enabled);
    String getDescription();
    void setDescription(String description);
    GroupType getType();
    void setType(GroupType type);
    List<GroupSocial> getParents();
    List<GroupSocial> getChildren();
    
}
