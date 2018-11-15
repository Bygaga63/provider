package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.groups.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupsRepo extends JpaRepository<Groups, Long> {
}
