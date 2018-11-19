package com.job.dynamicproviders.web.controller;

import com.job.dynamicproviders.model.providers.ProviderAttribute;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.job.dynamicproviders.model.providers.ProviderType.*;

@Controller
@RequestMapping("/templates")
@AllArgsConstructor
public class TemplateController {

    private ProviderTypeTemplateRepository providerTypeTemplateRepository;

    @GetMapping("/types")
    public String getTemplatesName(Model model) {
        List<ProviderType> providerTypes = Arrays.asList(LDAP, SAML, OAUTH2, OPENID);
        model.addAttribute("providerTypes", providerTypes);
        return "providerList";
    }

    @GetMapping("/{type}")
    public String showProviderByTemplate(@PathVariable String type, Model model) {
        ProviderType providerType = ProviderType.valueOf(type);
        ProviderTypeTemplate template = providerTypeTemplateRepository.findByType(providerType);

        model.addAttribute("template", template);
        return "providerCreate";
    }

    @PostMapping("/{type}")
    public String showResult(@RequestBody MultiValueMap<String, String> attributes,
                             @PathVariable String type, Model model) {
        List<ProviderAttribute> providerAttributes = attributes.entrySet().stream()
                .map(entity -> ProviderAttribute.builder().type(entity.getKey()).value(entity.getValue().get(0)).build())
                .collect(Collectors.toList());

        model.addAttribute("attributes", providerAttributes);
        model.addAttribute("type", type);

        return "providerResult";

    }

    @GetMapping("/template")
    @ResponseBody
    public ProviderTypeTemplate providerTypeTemplate() {
        return providerTypeTemplateRepository.findByType(ProviderType.OPENID);
    }


}
