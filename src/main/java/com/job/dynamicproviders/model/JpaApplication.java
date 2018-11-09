package com.job.dynamicproviders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.model.providers.DynamicProvider;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author men
 */
@Entity
@Table(name="application")
@JsonIgnoreProperties({"clientSecret", "homeDir"})
@Data
public class JpaApplication extends JpaGroupOwner implements Application {
    
    //public static final String FINDBY_APPNAME = "q.app.findbyappname";
    @Basic
    @Column
    private String appName;
    
    @Basic
    @Column
    private String description;
    
    @Basic
    @Column(nullable=false, unique=true)
    private String clientId;
    
    @Basic
    @Column
    private String clientSecret;
    
    @Basic
    @Column
    private Integer accessTime = 900;
    
    @Basic
    @Column
    private Integer refreshTime =3600;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
//    @JoinColumn(name = "application_id")
    private List<DynamicProvider> providers;

    
    @Basic
    @Column
    private Boolean enabled = true;
    
    @Basic
    @Column
    private Long type;

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

}
