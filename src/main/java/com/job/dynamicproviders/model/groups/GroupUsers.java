package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.interfaces.Group;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.AbstractBaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames={"group_id", "user_id"})})
public class GroupUsers extends AbstractBaseEntity {
    private String groupId;
    private String userId;
    private Role userRole;

    public enum Role {
        USER, OWNER, ADMIN
    }
}
