package com.job.dynamicproviders.model.providers;

import com.job.dynamicproviders.model.AbstractBaseEntity;
import com.job.dynamicproviders.model.groups.GroupSocial;
import com.job.dynamicproviders.model.groups.JpaGroupSocial;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class ProviderUserGroups extends AbstractBaseEntity {
    @ManyToOne(targetEntity = JpaGroupSocial.class, optional = false)
    @JoinColumn(name="groups_id")
    private GroupSocial groups;
    @ManyToOne(targetEntity = Provider.class, optional = false)
    @JoinColumn(name="provider_id")
    private Provider provider;

    @Enumerated(EnumType.STRING)
    private GroupType groupType = GroupType.DEFAULT;


    public enum GroupType {
        CUSTOM, DEFAULT
    }
}
