package com.job.dynamicproviders.service;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.web.request.ProviderRequestModel;

import java.util.List;

public interface ProviderService {
    Provider create(Application application, User user);
    Provider create(ProviderRequestModel provider);
    Provider getById(Long providerId);
    List<Provider> getListByAppId(Long appId);
    List<Provider> getListByUserId(Long userId);
    boolean remove(Provider provider);
    Provider update(Provider provider);
}
