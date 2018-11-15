package com.job.dynamicproviders;

import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.DynamicProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.service.DynamicProviderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@SpringBootApplication
@Data
@AllArgsConstructor
public class DynamicprovidersApplication implements CommandLineRunner{

	private final DynamicProviderRepository providerRepository;
	private final ProviderTypeTemplateRepository providerTypeTemplateRepository;
	private final DynamicProviderService providerService;




	public static void main(String[] args) {
		SpringApplication.run(DynamicprovidersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//create dynamic provider
//		DynamicProvider provider = new DynamicProvider("CustomType");
//		//create provider attributes
//		ProviderAttribute providerAttribute = new ProviderAttribute("cleintId", "1234", provider);
//		provider.getProviderAttributes().add(providerAttribute);
//		providerRepository.save(provider);


		//create providerTypeTemplate
		ProviderTypeTemplate providerType = new ProviderTypeTemplate(ProviderType.LDAP);
		providerType.getPropertyName().add("cleintId");
		providerType.getPropertyName().add("redirectUri");
		providerType.getPropertyName().add("tokenUri");
		providerTypeTemplateRepository.save(providerType);


		ProviderTypeTemplate oauthTemplate = new ProviderTypeTemplate(ProviderType.OAUTH2);
		oauthTemplate.getPropertyName().add("response_type");
		oauthTemplate.getPropertyName().add("client_id");
		oauthTemplate.getPropertyName().add("client_secret");
		oauthTemplate.getPropertyName().add("redirect_uri");
		providerTypeTemplateRepository.save(oauthTemplate);

		ProviderTypeTemplate openIdTemplate = new ProviderTypeTemplate(ProviderType.OPENID);
		openIdTemplate.getPropertyName().add("userAuthorizationUri");
		openIdTemplate.getPropertyName().add("redirectUri");
		openIdTemplate.getPropertyName().add("clientId");
		openIdTemplate.getPropertyName().add("client_secret");
		providerTypeTemplateRepository.save(openIdTemplate);


//		System.out.println(providerTypeTemplateRepository.findByType(ProviderType.OPENID));
	}
}
