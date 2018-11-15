package com.job.dynamicproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.job.dynamicproviders.interfaces.Person;
import com.job.dynamicproviders.interfaces.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("User")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class JpaUser extends JpaAbstractUser  {

    public static final String GET_BY_EMAIL = "q.user.getbyemail";
    public static final String GET_BY_USERNAME = "q.user.getbyusername";
    public static final String GET_BY_LOGIN = "q.user.getbylogin";
    public static final String GET_USERS_BY_COMPANY = "select u from JpaUser u join u.roles r where r.roleName=?1";

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "expired")
    private boolean expired;

    @Basic
    @Column(name = "locked")
    private boolean locked;

    @Basic
    @Column(name = "enabled")
    private boolean enabled;

    @Basic
    @Column(name = "forgotPasswordHash", unique = true)
    private String forgotPasswordHash;

    @Basic
    @Column(name = "password_hash_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date forgotPasswordTime;

    @Basic
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Transient
    private String confirmPassword;

    @Transient
    private String authType;

    @Basic
    @Column(name = "email", unique = true)
    protected String email;

    @Basic
    @Column(name = "phone", unique = true)
    protected String phone;

    @Basic
    @Column(name = "display_name", length = 255)
    protected String displayName;

    @Basic
    @Column(name = "additional_name", length = 255)
    protected String additionalName;

    @Basic
    @Column(name = "family_name", length = 255)
    protected String familyName;

    @Basic
    @Column(name = "given_name", length = 255)
    protected String givenName;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String userId) {

    }

    @Override
    public boolean hasRole(String roleName) {
        return false;
    }

}