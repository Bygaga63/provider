package com.job.dynamicproviders.repository;

import com.job.dynamicproviders.model.groups.Group;
import com.job.dynamicproviders.model.groups.JpaUserGroup;
import com.job.dynamicproviders.model.groups.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserGroupRepo extends JpaRepository<JpaUserGroup, Long>{

//    @Query("select ug from JpaUserGroup ug where ug.group.id = ?1")
//    List<JpaUserGroup> find(@Param("id") Long id);
    List<JpaUserGroup> findAllByGroup(Group group);
}
