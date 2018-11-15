package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.groups.ProviderUserGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderUserGroupsRepo extends JpaRepository<ProviderUserGroups, Long> {
}
