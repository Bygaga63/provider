package com.job.dynamicproviders.service;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderAttribute;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.web.request.ProviderRequestModel;

import java.util.List;
import java.util.Set;

public interface ProviderService {
    Provider create(String name, String descriptions, ProviderType type, List<ProviderAttribute> attributes, Application application, User user);
    Provider create(ProviderRequestModel provider);

    Provider getById(Long providerId);

    List<Provider> getListByAppId(Long appId);
    List<Provider> getListByUserId(Long userId);

    void remove(Provider provider);
    void remove(Long providerId);

    Provider update(Long providerId, ProviderRequestModel provider);
    Provider update(Provider provider);

    ProviderTypeTemplate getProviderTemplateByType(String type);
    ProviderTypeTemplate getProviderTemplateByType(ProviderType type);

    ProviderTypeTemplate updateProviderTemplate(String type, Set<String> propertyNames);

    void removeProviderTemplate(String type);
}
