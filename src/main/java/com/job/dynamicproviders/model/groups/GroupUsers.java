package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.interfaces.Group;
import com.job.dynamicproviders.interfaces.Person;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.AbstractBaseEntity;
import com.job.dynamicproviders.model.JpaUser;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
//@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"group_id", "user_id"})})
public class GroupUsers extends AbstractBaseEntity {

    @OneToOne
    @JoinColumn(name = "group_id")
//    @Column(name = "group_id")
    private Groups groups;

    @OneToOne
    @JoinColumn(name = "user_id")
//    @Column(name = "user_id")
    private JpaUser person;

//
//    @Column(name = "group_id")
//    private String groupId;
//    @Column(name = "user_id")
//    private String userId;


    @Enumerated(EnumType.STRING)
    private Role userRole;

    public enum Role {
        USER, OWNER, ADMIN
    }
}
