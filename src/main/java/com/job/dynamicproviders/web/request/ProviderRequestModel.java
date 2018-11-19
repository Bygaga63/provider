package com.job.dynamicproviders.web.request;

import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.providers.ProviderAttribute;
import com.job.dynamicproviders.model.providers.ProviderType;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ProviderRequestModel {
    private String type;
    private String name;
    private String description;
    private Map<String, String> attributes;
    private Long userId;
    private Long appId;
}
