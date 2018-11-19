package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderTypeTemplateRepository extends JpaRepository<ProviderTypeTemplate, Long>{
    Optional<ProviderTypeTemplate> findByType(ProviderType type);
}
