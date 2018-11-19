package com.job.dynamicproviders.service;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderAttribute;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.ApplicationRepository;
import com.job.dynamicproviders.repository.ProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.repository.UserRepository;
import com.job.dynamicproviders.web.exeptions.CustomException;
import com.job.dynamicproviders.web.request.ProviderRequestModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderTypeTemplateRepository typeTemplateRepository;
    private final ApplicationRepository applicationRepo;
    private final UserRepository userRepository;
    private final ProviderTypeTemplateRepository providerTypeTemplateRepository;

    @Override
    public Provider create(String name, String descriptions, ProviderType type, List<ProviderAttribute> attributes, Application application, User user) {

        if (!StringUtils.hasText(name)) {
            throw new CustomException("Provider name not found");
        }

        Provider provider = Provider.builder()
                .name(name)
                .description(descriptions)
                .type(type)
                .attributes(attributes)
                .application(application)
                .user(user)
                .build();

        return providerRepository.save(provider);
    }

    @Override
    public Provider create(ProviderRequestModel provider) {

        Application application =  getProviderApp(provider.getAppId());
        User user = getProviderUser(provider.getUserId());

        List<ProviderAttribute> attributes = convertMapToAttributes(provider.getAttributes());
        ProviderType type = getTypeByString(provider.getType());

        return create(provider.getName(), provider.getDescription(), type, attributes, application, user);
    }


    @Override
    public Provider getById(Long providerId) {
        return providerRepository.findById(providerId)
                .orElseThrow(() -> new CustomException("Provider not found"));
    }

    @Override
    public List<Provider> getListByAppId(Long appId) {
        return providerRepository.findAllByAppId(appId);
    }

    @Override
    public List<Provider> getListByUserId(Long userId) {
        return providerRepository.findAllByUserId(userId);
    }

    @Override
    public void remove(Provider provider) {
        providerRepository.delete(provider);
    }

    @Override
    public void remove(Long providerId) {
        Provider provider = getById(providerId);
        remove(provider);
    }

    @Override
    public Provider update(Long providerId, ProviderRequestModel provider) {
        Provider providerFromDb = getById(providerId);

        Application application =  getProviderApp(provider.getAppId());
        User user = getProviderUser(provider.getUserId());
        ProviderType type = getTypeByString(provider.getType());
        List<ProviderAttribute> attributes = convertMapToAttributes(provider.getAttributes());

        providerFromDb.setName(provider.getName());
        providerFromDb.setDescription(provider.getDescription());
        providerFromDb.setType(type);
        providerFromDb.setAttributes(attributes);
        providerFromDb.setApplication(application);
        providerFromDb.setUser(user);

        return update(providerFromDb);
    }

    @Override
    public Provider update(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public ProviderTypeTemplate getProviderTemplateByType(String type) {
        ProviderType providerType = getTypeByString(type);
        return getProviderTemplateByType(providerType);
    }

    @Override
    public ProviderTypeTemplate getProviderTemplateByType(ProviderType type) {
        return providerTypeTemplateRepository.findByType(type)
                .orElseThrow(()-> new CustomException("Provider template not found"));
    }

    @Override
    public void removeProviderTemplate(String type) {
        ProviderTypeTemplate template = getProviderTemplateByType(type);
        providerTypeTemplateRepository.delete(template);
    }

    @Override
    public ProviderTypeTemplate updateProviderTemplate(String type, Set<String> propertyNames) {
        ProviderTypeTemplate typeTemplate = getProviderTemplateByType(type);
        typeTemplate.setPropertyName(propertyNames);
        return providerTypeTemplateRepository.save(typeTemplate);
    }

    private List<ProviderAttribute> convertMapToAttributes(Map<String, String> attributes) {
        if (MapUtils.isEmpty(attributes)) {
            return Collections.emptyList();
        }
        return attributes.entrySet().stream()
                .map(elem -> new ProviderAttribute(elem.getKey(), elem.getValue()))
                .collect(Collectors.toList());
    }

    private ProviderType getTypeByString(String type) {
        try {
            return ProviderType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException| NullPointerException e) {
            throw new CustomException("Provider type is incorrect");
        }
    }

    private Application getProviderApp(Long appId){
        return applicationRepo
                .findById(appId)
                .orElseThrow(() -> new CustomException("Application not found"));
    }

    private User getProviderUser(Long userId){
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new CustomException("User not found"));
    }
}
