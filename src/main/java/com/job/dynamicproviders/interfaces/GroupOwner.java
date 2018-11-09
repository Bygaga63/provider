package com.job.dynamicproviders.interfaces;

public interface GroupOwner extends Group {
    public User getUser();
    public void setUser(User user);
    public String getUserId();
    public String getImageId();
    public void setImageId(String imageId);
    public String getHomeDir();
    public void setHomeDir(String homeDir);
}