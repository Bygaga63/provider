package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.providers.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    @Query("select p from Provider p where p.application.id = ?1")
    List<Provider> findAllByAppId(@Param("id") Long appId);

    @Query("select p from Provider p where p.user.id = ?1")
    List<Provider> findAllByUserId(@Param("id") Long userId);
}
