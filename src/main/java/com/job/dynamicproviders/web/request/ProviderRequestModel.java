package com.job.dynamicproviders.web.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Data
public class ProviderRequestModel {
    @Pattern(regexp = "(?i)(SAML|OAUTH2|LDAP|OPENID|CUSTOM)", message = "Incorrect provider type")
    private String type;
    @NotBlank(message = "Provider name is required")
    private String name;
    private String description;
    private Map<String, String> attributes;
    @NotNull(message = "userId is required")
    private Long userId;
    @NotNull (message = "appId is required")
    private Long appId;
}
