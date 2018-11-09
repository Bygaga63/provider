package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.JpaApplication;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<JpaApplication, Long> {

}
