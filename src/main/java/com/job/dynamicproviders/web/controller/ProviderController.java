package com.job.dynamicproviders.web.controller;

import com.job.dynamicproviders.Message;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.service.ProviderService;
import com.job.dynamicproviders.service.ValidationErrorService;
import com.job.dynamicproviders.utils.NumberUtils;
import com.job.dynamicproviders.web.exeptions.CustomException;
import com.job.dynamicproviders.web.request.ProviderRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/providers")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;
    private final ValidationErrorService errorService;


    @GetMapping("/app/{appId}")
    public Message getListByAppId(@PathVariable String appId) {

        List<Provider> providerList = providerService.getListByAppId(Long.parseLong(appId));
        return new Message(true, "Ok", 200, providerList, "");
    }

    @GetMapping("/user/{userId}")
    public Message getListByUserId(@PathVariable String userId) {
        List<Provider> providerList = providerService.getListByUserId(Long.parseLong(userId));
        return new Message(true, "Ok", 200, providerList, "");
    }

    @PostMapping
    public Message create(@RequestBody @Valid ProviderRequestModel provider, BindingResult result) {
        Message errorMessage = errorService.MapValidationService(result);
        if (errorMessage != null) return errorMessage;
        Provider providerFromDb = providerService.create(provider);
        return new Message(true, "Ok", 200, providerFromDb, "");
    }

    @PutMapping("{providerId}")
    public Message update(@PathVariable String providerId, @RequestBody @Valid ProviderRequestModel provider, BindingResult result) {
        Message errorMessage = errorService.MapValidationService(result);
        if (errorMessage != null) return errorMessage;

        if (NumberUtils.isNumeric(providerId)) {
            Long id = Long.parseLong(providerId);
            Provider providerFromDb = providerService.update(id, provider);
            return new Message(true, "Ok", 200, providerFromDb, "");
        }

        throw new CustomException("providerId must be number");
    }


    @DeleteMapping("{providerId}")
    public Message delete(@PathVariable String providerId) {
        if (NumberUtils.isNumeric(providerId)) {
            providerService.remove(Long.parseLong(providerId));
            return new Message(true, "Ok");
        }
        throw new CustomException("Provider not found");
    }

    @GetMapping("/types")
    public ProviderType[] getProviderTemplates() {
        return ProviderType.values();
    }

    @GetMapping("/types/{type}")
    public Message getProviderTemplateByType(@PathVariable String type) {
        ProviderTypeTemplate template = providerService.getProviderTemplateByType(type);
        return new Message(true, "OK", 200, template, "");
    }

    @PutMapping("/types/{type}")
    public Message updateProviderTemplate(@PathVariable String type, @RequestBody Set<String> propertyNames) {
        ProviderTypeTemplate template = providerService.updateProviderTemplate(type, propertyNames);
        return new Message(true, "OK", 200, template, "");
    }

    @DeleteMapping("/types/{type}")
    public Message deleteProviderTemplate(@PathVariable String type) {
        providerService.removeProviderTemplate(type);
        return new Message(true, "OK");
    }
}
