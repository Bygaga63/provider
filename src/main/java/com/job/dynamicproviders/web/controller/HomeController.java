package com.job.dynamicproviders.web.controller;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.model.JpaApplication;

import com.job.dynamicproviders.model.providers.Provider;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.repository.ApplicationRepository;
import com.job.dynamicproviders.repository.ProviderRepository;
import com.job.dynamicproviders.repository.UserRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.service.ProviderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@AllArgsConstructor
public class HomeController {
    private final ProviderTypeTemplateRepository providerTypeTemplateRepository;
    private final ProviderServiceImpl providerService;
    private final ProviderRepository providerRepository;
    private final ApplicationRepository applicationRepository;
//
//    private final GroupsRepo groupsRepo;
//    private final ProviderUserGroupsRepo providerUserGroupsRepo;
//    private final GroupUsersRepo groupUsersRepo;
    private final UserRepository userRepo;


//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/db")
    public String db(){
        return "redirect:/db";
    }


    @GetMapping("/provider")
    @ResponseBody
    public List<Provider> createProviderByTemplate(){
        Provider openId = providerService.createByTemplate(ProviderType.OPENID);
        Provider oauth = providerService.createByTemplate(ProviderType.OAUTH2);
        Provider ldap = providerService.createByTemplate(ProviderType.LDAP);
        providerRepository.saveAll(Arrays.asList(openId,oauth, ldap));
        return providerRepository.findAll();
    }

    @GetMapping("/app")
    @ResponseBody
    public Application createApplication(){
        JpaApplication application = new JpaApplication();
        application.setType(1L);
        application.setClientId("123");

        Provider openId = providerService.createByTemplate(ProviderType.OPENID);
        Provider oauth = providerService.createByTemplate(ProviderType.OAUTH2);
        Provider ldap = providerService.createByTemplate(ProviderType.LDAP);
        oauth.setApplication(application);
        openId.setApplication(application);
        ldap.setApplication(application);
//        application.setProviders((Arrays.asList(openId,oauth, ldap)));
        applicationRepository.save(application);
        return application;
    }

    @GetMapping("/test")
    @ResponseBody
    public List<Provider> dynamicProvider(){
        List<Provider> allByAppId = providerRepository.findAllByAppId(1L);
        return allByAppId;
//        Optional<JpaApplication> byId = applicationRepository.findById(1L);
//
//
//        Map<String, String> map = new HashMap<String, String>() {{put("Dima", "28");}};
//        map.forEach((key, value) -> System.out.println(key + "= " + value));
//        return providerRepository.findAllByAppId(1L);
    }

//
//    @GetMapping("test2")
//    @ResponseBody
//    public List<PostComment> test2(){
//        Post post = new Post("First post");
//
//        PostComment myFirstReview = new PostComment("My first review");
//        myFirstReview.setPost(post);
//        PostComment my_second_review = new PostComment("My second review");
//        my_second_review.setPost(post);
//        PostComment my_third_review = new PostComment("My third review");
//        my_third_review.setPost(post);
//
//        postRepository.save(post);
//        postCommentRepository.saveAll(Arrays.asList(myFirstReview, my_second_review, my_third_review));
//        return postCommentRepository.findMany();
//    }


//    @GetMapping("/groups")
//    @ResponseBody
    public void groups(){
        Provider provider1 =  Provider.builder().name("Provider1").type(ProviderType.OAUTH2).build();
        Provider provider2 =  Provider.builder().name("Provider2").type(ProviderType.SAML).build();

        providerRepository.save(provider1);
        providerRepository.save(provider2);





//        GroupSocial groupSocial = new JpaGroupSocial()
//        Groups group1 = Groups.builder().name("group1").active(true).created(LocalDateTime.now()).usersNumber(5).build();
//        Groups group2 = Groups.builder().name("group2").active(true).created(LocalDateTime.now()).usersNumber(10).build();
//
//        groupsRepo.save(group1);
//        groupsRepo.save(group2);
//
//        JpaUser user1 = JpaUser.builder().username("Dima").build();
//        JpaUser user2 = JpaUser.builder().username("Kola").build();
//        JpaUser user3 = JpaUser.builder().username("Sasha").build();
//        JpaUser user4 = JpaUser.builder().username("LOLo").build();
//
//        userRepo.save(user1);
//        userRepo.save(user2);
//        userRepo.save(user3);
//        userRepo.save(user4);
//
//        com.job.dynamicproviders.model.providers.ProviderUserGroups providerUserGroups1 = com.job.dynamicproviders.model.providers.ProviderUserGroups.builder().groups(group1).groupType(com.job.dynamicproviders.model.providers.ProviderUserGroups.GroupType.DEFAULT).provider(provider1).build();
//        com.job.dynamicproviders.model.providers.ProviderUserGroups providerUserGroups2 = com.job.dynamicproviders.model.providers.ProviderUserGroups.builder().groups(group1).groupType(com.job.dynamicproviders.model.providers.ProviderUserGroups.GroupType.CUSTOM).provider(provider2).build();
//
//        providerUserGroupsRepo.save(providerUserGroups1);
//        providerUserGroupsRepo.save(providerUserGroups2);
//
//        GroupUsers groupUsers1 = GroupUsers.builder().person(user1).groups(group1).build();
//        GroupUsers groupUsers2 = GroupUsers.builder().person(user2).groups(group1).userRole(GroupUsers.Role.OWNER).build();
//        GroupUsers groupUsers3 = GroupUsers.builder().person(user3).groups(group2).userRole(GroupUsers.Role.OWNER).build();
//        GroupUsers groupUsers4 = GroupUsers.builder().person(user4).groups(group2).userRole(GroupUsers.Role.OWNER).build();
//
//        groupUsersRepo.save(groupUsers1);
//        groupUsersRepo.save(groupUsers2);
//        groupUsersRepo.save(groupUsers3);
//        groupUsersRepo.save(groupUsers4);

    }
}
