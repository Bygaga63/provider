/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;


/**
 *
 * @author root
 */
public interface GroupType {
    Long getId();
    void setId(Long id);
    String getName();
    void setName(String name);
    GroupTypeAccess getAccess();
    void setAccess(GroupTypeAccess access);
}
