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

public interface GroupOwner extends Group {
    public User getUser();
    public void setUser(User user);  
    public String getUserId();
    public String getImageId();
    public void setImageId(String imageId);
    public String getHomeDir();
    public void setHomeDir(String homeDir);
}
