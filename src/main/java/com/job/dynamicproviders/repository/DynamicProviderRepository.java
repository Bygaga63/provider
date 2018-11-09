package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.providers.DynamicProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DynamicProviderRepository extends JpaRepository<DynamicProvider, Long> {

    List<DynamicProvider> findDynamicProvidersByApplication_EntityId(Long id);
}
