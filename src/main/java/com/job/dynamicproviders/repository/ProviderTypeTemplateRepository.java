package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderTypeTemplateRepository extends JpaRepository<ProviderTypeTemplate, Long>{
    ProviderTypeTemplate findByType(ProviderType type);
}
