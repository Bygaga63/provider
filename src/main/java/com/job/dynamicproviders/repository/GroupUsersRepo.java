package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.groups.GroupUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupUsersRepo extends JpaRepository<GroupUsers, Long> {
}
