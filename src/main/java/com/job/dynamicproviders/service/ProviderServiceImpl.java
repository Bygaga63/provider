package com.job.dynamicproviders.service;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.interfaces.User;
import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.ApplicationRepository;
import com.job.dynamicproviders.repository.ProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.repository.UserRepository;
import com.job.dynamicproviders.web.request.ProviderRequestModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderTypeTemplateRepository typeTemplateRepository;
    private final ApplicationRepository applicationRepo;
    private final UserRepository userRepository;

    public Provider createByTemplate(ProviderType providerType) {
        ProviderTypeTemplate template = typeTemplateRepository.findByType(providerType);
        Provider provider = new Provider(providerType);
        template.getPropertyName()
                .forEach(propName -> {
//                    ProviderAttribute providerAttribute = new ProviderAttribute(propName, null, provider);
//                    provider.getAttributes().add(providerAttribute);
                });
        providerRepository.save(provider);
        return provider;
    }


    @Override
    public Provider create(Application application, User user) {
        return null;
    }

    @Override
    public Provider create(ProviderRequestModel model) {

        JpaApplication application = applicationRepo
                .findById(model.getAppId())
                .orElseThrow(() -> (new RuntimeException("app not found")));

        JpaUser user = userRepository
                .findById(model.getUserId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        return create(application, user);
    }


    @Override
    public Provider getById(Long providerId) {
        return providerRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("provider not found"));
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
    public boolean remove(Provider provider) {
        providerRepository.delete(provider);

        return providerRepository.findById(provider.getId()).isPresent();
    }

    @Override
    public Provider update(Provider provider) {
        return providerRepository.save(provider);
    }
}
