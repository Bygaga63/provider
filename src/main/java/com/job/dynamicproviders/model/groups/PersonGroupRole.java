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

public enum PersonGroupRole {
    User(0), Admin(1), Master(2);
    
    private final int id;
    PersonGroupRole(int id) { this.id = id; }
    public int getValue() { return id; }
};
