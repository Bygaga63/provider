/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.interfaces.User;

/**
 *
 * @author root
 */
public interface UserGroup {
    Long getId();
    void setId(Long id);
    User getUser();
    void setUser(User user);
    GroupSocial getGroup();
    void setGroup(GroupSocial group);
    PersonGroupRole getRole();
    void setRole(PersonGroupRole role);
}
