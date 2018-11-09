package com.job.dynamicproviders.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.Date;

@JsonIgnoreProperties({"password"})
public interface User {

    public static final String PFX = "user_";
    
    String getId();
    void setId(String userId);

    void setUsername(String username);
    void setPassword(String password);
    boolean isLocked();
    void setLocked(boolean locked);
    boolean isExpired();
    void setExpired(boolean expired);
    void setEnabled(boolean enabled);

    String getAuthType();
    void setAuthType(String authType);
    
    String getForgotPasswordHash();
    void setForgotPasswordHash(String forgotPasswordHash);
    Date getForgotPasswordTime();
    void setForgotPasswordTime(Date forgotPasswordTime);
    String getConfirmPassword();
    void setConfirmPassword(String confirmPassword);
    boolean hasRole(String roleName);
}
