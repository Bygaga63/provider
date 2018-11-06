package com.job.dynamicproviders.model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class User extends AbstractBaseEntity{
    List<DynamicProvider> providers;
}
