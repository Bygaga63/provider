package com.job.dynamicproviders.controller;

import com.job.dynamicproviders.dto.ProviderAttributesListRequest;
import com.job.dynamicproviders.model.providers.ProviderAttribute;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import static com.job.dynamicproviders.model.providers.ProviderType.*;

@Controller
@RequestMapping("/templates")
@AllArgsConstructor
public class TemplateController {

    private ProviderTypeTemplateRepository providerTypeTemplateRepository;

    @GetMapping("/types")
    public String getTemplatesName(Model model){
        List<ProviderType> providerTypes = Arrays.asList(LDAP, SAML, OAUTH2, OPENID);
        model.addAttribute("providerTypes", providerTypes);
        return "templateType";
    }

    @GetMapping("/{type}")
    public String showProviderByTemplate(@PathVariable String type, Model model){
        ProviderType providerType = ProviderType.valueOf(type);
        ProviderTypeTemplate template = providerTypeTemplateRepository.findByType(providerType);

        model.addAttribute("template", template);
        return "template";

    }

    @PostMapping
    public String showResult( ProviderAttributesListRequest attributes){
//        model.addAttribute("attributes", attributes);

        return "resultProvider";

    }

    @GetMapping("/template")
    @ResponseBody
    public ProviderTypeTemplate providerTypeTemplate(){
        return providerTypeTemplateRepository.findByType(ProviderType.OPENID);
    }


}
