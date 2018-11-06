package com.job.dynamicproviders.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "providerAttributes")
public class DynamicProvider extends AbstractBaseEntity{

    private String type;

    @OneToMany(mappedBy = "dynamicProviders", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProviderAttribute> providerAttributes = new ArrayList<>();


    public DynamicProvider(String type) {
        this.type = type;
    }
}
