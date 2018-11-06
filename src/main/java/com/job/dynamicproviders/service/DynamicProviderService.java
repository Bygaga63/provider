package com.job.dynamicproviders.service;

import com.job.dynamicproviders.model.DynamicProvider;
import com.job.dynamicproviders.model.ProviderAttribute;
import com.job.dynamicproviders.model.ProviderType;
import com.job.dynamicproviders.model.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.DynamicProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class DynamicProviderService {
    private final DynamicProviderRepository providerRepository;
    private final ProviderTypeTemplateRepository typeTemplateRepository;

    public DynamicProvider createByTemplate(ProviderType providerType){
        ProviderTypeTemplate template = typeTemplateRepository.findByType(providerType);
        DynamicProvider dynamicProvider = new DynamicProvider(providerType.name());
        template.getPropertyName()
                .forEach(propName -> {
                    ProviderAttribute providerAttribute = new ProviderAttribute(propName, null, dynamicProvider);
                    dynamicProvider.getProviderAttributes().add(providerAttribute);
                });
        return dynamicProvider;
    }

}