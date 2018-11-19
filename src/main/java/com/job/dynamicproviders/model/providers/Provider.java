package com.job.dynamicproviders.model.providers;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private ProviderType type;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private List<ProviderAttribute> attributes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "app_id")
    private JpaApplication application;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private JpaUser user;

    public Provider(ProviderType type) {
        this.type = type;
    }
}
