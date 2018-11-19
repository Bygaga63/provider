package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<JpaUser, Long> {
}
