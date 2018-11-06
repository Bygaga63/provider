package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.ProviderType;
import com.job.dynamicproviders.model.ProviderTypeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderTypeTemplateRepository extends JpaRepository<ProviderTypeTemplate, Long>{
    ProviderTypeTemplate findByType(ProviderType type);
}
