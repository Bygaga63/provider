package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.DynamicProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DynamicProviderRepository extends JpaRepository<DynamicProvider, Long> {
}
