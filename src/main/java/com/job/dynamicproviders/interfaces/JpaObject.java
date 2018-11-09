package com.job.dynamicproviders.interfaces;

import java.io.Serializable;

public interface JpaObject extends Serializable {
    public Long getEntityId();
    public void setEntityId(Long id);
}
