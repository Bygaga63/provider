package com.job.dynamicproviders.model.providers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.AbstractBaseEntity;
import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.JpaUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString(exclude = "attributes")
public class Provider extends AbstractBaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private ProviderType type;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private List<ProviderAttribute> attributes = new ArrayList<>();

    @ManyToOne(targetEntity = JpaApplication.class)
    @JoinColumn(name = "app_id")
    @JsonIgnore
    private Application application;

    @ManyToOne(targetEntity = JpaUser.class)
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private User user;

    public Provider(ProviderType type) {
        this.type = type;
    }
}
