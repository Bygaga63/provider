package com.job.dynamicproviders.dto;

import com.job.dynamicproviders.model.providers.ProviderAttribute;
import lombok.Data;

import java.util.List;

@Data
public class ProviderAttributesListRequest {
    List<ProviderAttribute> providerAttributes;
}
