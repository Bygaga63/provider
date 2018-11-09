/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.job.dynamicproviders.model.providers.DynamicProvider;

import java.util.List;

/**
 *
 * @author men
 */
@JsonIgnoreProperties({"company", "clientSecret"})
public interface Application extends GroupOwner {

//    public Long getId();
//
//    public void setId(Long id);

//    public Company getCompany();

//    public void setCompany(Company company);

    public void setClientId(String clientId);

    public void setClientSecret(String clientSecret);

    public Integer getAccessTime();

    public void setAccessTime(Integer accessTime);

    public Integer getRefreshTime();

    public void setRefreshTime(Integer refreshTime);

    String getAppName();

    void setAppName(String appName);

    String getDescription();

    void setDescription(String desc);

    
    Long getType();

    void setType(Long type);

    void setProviders(List<DynamicProvider> list);

    List<DynamicProvider> getProviders();
}
