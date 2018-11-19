package com.job.dynamicproviders;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.ApplicationRepository;
import com.job.dynamicproviders.repository.ProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.repository.UserRepository;
import com.job.dynamicproviders.service.ProviderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Data
@AllArgsConstructor
public class DynamicprovidersApplication implements CommandLineRunner{

	private final ProviderRepository providerRepository;
	private final ProviderTypeTemplateRepository providerTypeTemplateRepository;
	private final ProviderServiceImpl providerServiceImpl;
	private final UserRepository userRepo;
	private final ApplicationRepository applicationRepo;


	public static void main(String[] args) {
		SpringApplication.run(DynamicprovidersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<JpaUser> users = createUsers();
		Application application = createApplications(users.get(0));

		Provider provider1 =  Provider.builder().name("Provider1").type(ProviderType.OAUTH2).application((JpaApplication) application).user(users.get(0)).build();
		Provider provider2 =  Provider.builder().name("Provider2").type(ProviderType.SAML).application((JpaApplication) application).user(users.get(0)).build();
		providerRepository.save(provider1);
		providerRepository.save(provider2);

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

		ProviderTypeTemplate samlTemplate = new ProviderTypeTemplate(ProviderType.SAML);
		samlTemplate.getPropertyName().add("userAuthorizationUri");
		samlTemplate.getPropertyName().add("redirectUri");
		samlTemplate.getPropertyName().add("clientId");
		samlTemplate.getPropertyName().add("client_secret");
		providerTypeTemplateRepository.save(samlTemplate);
//		System.out.println(providerTypeTemplateRepository.findByType(ProviderType.OPENID));
	}


	private List<JpaUser> createUsers(){
		JpaUser Dima = JpaUser.builder().username("Dima").build();
		JpaUser Misha = JpaUser.builder().username("Misha").build();
		JpaUser Vadim = JpaUser.builder().username("Vadim").build();
		JpaUser Sasha = JpaUser.builder().username("Sasha").build();
		JpaUser Lena = JpaUser.builder().username("Lena").build();
		JpaUser Kola = JpaUser.builder().username("Kola").build();
		JpaUser Arkasha = JpaUser.builder().username("Arkasha").build();

		return userRepo.saveAll(Arrays.asList(Dima, Misha, Vadim, Sasha, Lena, Kola, Arkasha));

	}


	private Application createApplications(JpaUser user){
		JpaApplication application = new JpaApplication();
		application.setAppName("Bygaga63");
		application.setClientId("1235678");
		application.setUser(user);
		return applicationRepo.save(application);
	}
}
