package com.job.dynamicproviders.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderAttribute extends AbstractBaseEntity{

    private String type;
    private String value;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    @JsonBackReference
    private DynamicProvider dynamicProviders;
}
