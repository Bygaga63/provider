/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.JpaGroup;
import com.job.dynamicproviders.model.JpaUser;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author root
 */
@MappedSuperclass
public abstract class JpaGroupOwner extends JpaGroup implements GroupOwner{
    @ManyToOne(targetEntity=JpaUser.class)
    @JoinColumn(name="owner", nullable = true)
    private User user;
    
    @Column(name="image_id")
    private String imageId;
    
    @Column(name="home_dir")
    private String homeDir;
    
    @Override
    public User getUser() {
        return user;
    }
    @Override
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String getUserId() {
        return user.getId();
    }
    
    /**
     * Получить id изображение группы
     * 
     * @return id изображение группы
     */
    @Override
    public String getImageId() {
        return this.imageId;
    }
    
    /**
     * Установить id изображение группы
     * 
     * @param imageId id изображение группы
     */
    @Override
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    
    /**
     * Получить домашнюю директорию группы
     * 
     * @return домашняя директорию группы
     */
    @Override
    public String getHomeDir() {
        return this.homeDir;
    }
    
    /**
     * Установить домашнюю директорию группы
     * 
     * @param homeDir домашняя директория
     */
    @Override
    public void setHomeDir(String homeDir) {
        this.homeDir = homeDir;
    }
}
