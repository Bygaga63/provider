package com.job.dynamicproviders.interfaces;

import com.job.dynamicproviders.model.GroupTypeAccess;

public interface GroupType {
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    GroupTypeAccess getAccess();
    void setAccess(GroupTypeAccess access);
}