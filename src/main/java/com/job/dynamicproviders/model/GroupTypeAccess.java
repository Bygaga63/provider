package com.job.dynamicproviders.model;

public enum GroupTypeAccess {
    Private(0), Public(1);

    private final int id;
    GroupTypeAccess(int id) { this.id = id; }
    public int getValue() { return id; }
};