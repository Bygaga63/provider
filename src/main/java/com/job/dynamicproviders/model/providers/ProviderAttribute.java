package com.job.dynamicproviders.model.providers;

import com.job.dynamicproviders.model.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProviderAttribute extends AbstractBaseEntity {
    private String type;
    private String value;

}
