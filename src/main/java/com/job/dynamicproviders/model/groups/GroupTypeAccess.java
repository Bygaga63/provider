/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.job.dynamicproviders.model.groups;

/**
 *
 * @author root
 */
public enum GroupTypeAccess {
    Private(0), Public(1);
    
    private final int id;
    GroupTypeAccess(int id) { this.id = id; }
    public int getValue() { return id; }
};
