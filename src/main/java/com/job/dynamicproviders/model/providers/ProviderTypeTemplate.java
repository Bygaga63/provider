package com.job.dynamicproviders.model.providers;

import com.job.dynamicproviders.model.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "propertyName")
public class ProviderTypeTemplate extends AbstractBaseEntity {

    @Enumerated(EnumType.STRING)
    private ProviderType type;

    @ElementCollection
    @CollectionTable(name = "ProviderProperty", joinColumns = @JoinColumn(name = "provider_id"))
    private Set<String> propertyName = new HashSet<>();

    public ProviderTypeTemplate(ProviderType type) {
        this.type = type;
    }

}
