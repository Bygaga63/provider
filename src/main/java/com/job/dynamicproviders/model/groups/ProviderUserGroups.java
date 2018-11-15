package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.model.AbstractBaseEntity;
import com.job.dynamicproviders.model.providers.DynamicProvider;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Builder
@Entity
public class ProviderUserGroups extends AbstractBaseEntity {
    @OneToOne
    private Groups groups;
    @OneToOne
    private DynamicProvider dynamicProvider;
    @Enumerated(EnumType.STRING)
    private GroupType groupType;


    public enum GroupType {
        CUSTOM, DEFAULT
    }
}
