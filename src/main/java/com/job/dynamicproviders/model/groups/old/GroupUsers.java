//package com.job.dynamicproviders.model.groups;
//
//import com.job.dynamicproviders.interfaces.Group;
//import com.job.dynamicproviders.interfaces.Person;
//import com.job.dynamicproviders.interfaces.User;
//import com.job.dynamicproviders.model.AbstractBaseEntity;
//import com.job.dynamicproviders.model.JpaGroup;
//import com.job.dynamicproviders.model.JpaUser;
//import lombok.Builder;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//@Builder
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"group_id", "user_id"})})
//public class GroupUsers extends AbstractBaseEntity {
//
//    @ManyToOne(targetEntity = Groups.class, optional=false)
//    @JoinColumn(name = "group_id")
//    private Groups groups;
//
//    @ManyToOne(targetEntity=JpaUser.class, optional=false)
//    @JoinColumn(name = "user_id")
//    private JpaUser person;
//
//
//    @Column(name = "roles", nullable = false)
//    @Enumerated(EnumType.STRING)
//    private PersonGroupRole role = PersonGroupRole.USER;
//
//    public PersonGroupRole getRole() {
//        return role;
//    }
//}
