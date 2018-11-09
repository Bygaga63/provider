package com.job.dynamicproviders.model;

import com.job.dynamicproviders.interfaces.GroupOwner;
import com.job.dynamicproviders.interfaces.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class JpaGroupOwner extends JpaGroup implements GroupOwner {
    @ManyToOne(targetEntity = JpaUser.class)
    @JoinColumn(name = "owner", nullable = true)
    private User user;

    @Column(name = "image_id")
    private String imageId;

    @Column(name = "home_dir")
    private String homeDir;
}