package com.job.dynamicproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.job.dynamicproviders.interfaces.Person;
import com.job.dynamicproviders.interfaces.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("User")
@JsonIgnoreProperties({"password", "expired", "locked", "enabled", "forgotPasswordHash",
        "password_hash_time", "roles", "preferredName",
        "accountNonExpired", "accountNonLocked", "credentialsNonExpired", "secret"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class JpaUser extends JpaAbstractUser implements User, Person {

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

    @Basic
    @Column(name = "honorific_prefix", length = 255)
    protected String honorificPrefix;

    @Basic
    @Column(name = "honorific_suffix", length = 255)
    protected String honorificSuffix;

    @Basic
    @Column(name = "preferred_name")
    protected String preferredName;

    @Basic
    @Column(name = "about_me")
    protected String aboutMe;

    @Basic
    @Column(name = "status")
    protected String status;

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

    @Override
    public void setLogin(String login) {

    }

    @Override
    public String getLogin() {
        return null;
    }
}