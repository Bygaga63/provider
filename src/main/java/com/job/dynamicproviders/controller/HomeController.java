package com.job.dynamicproviders.controller;

import com.job.dynamicproviders.model.DynamicProvider;
import com.job.dynamicproviders.model.ProviderType;
import com.job.dynamicproviders.model.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.DynamicProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.service.DynamicProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private final ProviderTypeTemplateRepository providerTypeTemplateRepository;
    private final DynamicProviderService providerService;
    private final DynamicProviderRepository providerRepository;
    @GetMapping
    public String db(){
        return "redirect:/db";
    }

    @GetMapping("/template")
    @ResponseBody
    public ProviderTypeTemplate providerTypeTemplate(){
        return providerTypeTemplateRepository.findByType(ProviderType.OPENID);
    }

    @GetMapping("/create")
    @ResponseBody
    public List<DynamicProvider> createProviderByTemplate(){
        DynamicProvider openId = providerService.createByTemplate(ProviderType.OPENID);
        DynamicProvider oauth = providerService.createByTemplate(ProviderType.OAUTH2);
        DynamicProvider ldap = providerService.createByTemplate(ProviderType.LDAP);
        providerRepository.saveAll(Arrays.asList(openId,oauth, ldap));
        return providerRepository.findAll();
    }
}
