package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.model.AbstractBaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
public class Groups extends AbstractBaseEntity {
    private String groupId;
    private String name;
    private String description;
    private boolean active;
    private LocalDateTime created;
    private String homeDir;
    private String imageId;
    private int usersNumber;
}
