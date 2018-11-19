package com.job.dynamicproviders.web.controller;

import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.groups.JpaGroupSocial;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderUserGroups;
import com.job.dynamicproviders.repository.*;
import com.job.dynamicproviders.service.ProviderService;
import com.job.dynamicproviders.web.request.ProviderRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/providers")
@AllArgsConstructor
public class ProviderController {
    private ProviderRepository providerRepository;
    private ProviderService providerService;
    private UserRepository userRepo;
    private GroupSocialRepository groupSocialRepository;
    private ProviderUserGroupsRepo providerUserGroupsRepo;
    private ApplicationRepository applicationRepo;
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @GetMapping
    public ProviderUserGroups createRelation(String id) {

        Long uid = Long.parseLong(id);
        Provider provider = providerRepository.findById(uid).get();
        JpaUser jpaUser = userRepo.findById(uid).get();
        JpaGroupSocial userGroup = groupSocialRepository.findById(uid).get();

        ProviderUserGroups providerUserGroups = new ProviderUserGroups();
        providerUserGroups.setProvider(provider);
        providerUserGroups.setGroups(userGroup);
        providerUserGroups.setGroupType(ProviderUserGroups.GroupType.DEFAULT);
        providerUserGroupsRepo.save(providerUserGroups);

        return providerUserGroups;
    }


    @PostMapping
    public Provider create(@RequestBody ProviderRequestModel provider){
        Optional<JpaApplication> application = applicationRepo.findById(provider.getAppId());
        Optional<JpaApplication> user = applicationRepo.findById(provider.getUserId());
        providerService.create();
        return null;
    }

//    @PutMapping
//    public Provider update(@RequestBody ProviderRequestModel provider){
//        return
//    }

    @GetMapping("/app")
    public List<Provider> findByAppId() {
        List<Provider> allByAppId = providerRepository.findAllByAppId(1L);
        return allByAppId;
    }

    @GetMapping("/user")
    public List<Provider> findByUserId() {
        List<Provider> allByUserId = providerRepository.findAllByUserId(1L);
        return allByUserId;
    }
}
