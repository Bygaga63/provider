package com.job.dynamicproviders.model.providers;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.job.dynamicproviders.model.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProviderAttribute extends AbstractBaseEntity {
    private String type;
    private String value;

}
