package com.job.dynamicproviders.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

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
