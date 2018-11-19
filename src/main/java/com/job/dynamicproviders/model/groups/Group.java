/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 *
 * @author root
 */
@JsonIgnoreProperties({"type", "enabled", "parents", "children"})
public interface Group {
    Long getId();
    void setId(Long id);
    Integer getLimit();
    void setLimit(Integer limit);    
    Boolean getEnabled();
    void setEnabled(Boolean enabled);
    Date getCreated();
    void setCreated(Date created);
}
