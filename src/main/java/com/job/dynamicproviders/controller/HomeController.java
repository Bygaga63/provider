package com.job.dynamicproviders.controller;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.interfaces.Group;
import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.groups.GroupUsers;
import com.job.dynamicproviders.model.groups.Groups;
import com.job.dynamicproviders.model.groups.ProviderUserGroups;
import com.job.dynamicproviders.model.post.Post;
import com.job.dynamicproviders.model.post.PostComment;
import com.job.dynamicproviders.model.post.PostCommentRepository;
import com.job.dynamicproviders.model.post.PostRepository;
import com.job.dynamicproviders.model.providers.DynamicProvider;
import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.*;
import com.job.dynamicproviders.service.DynamicProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@AllArgsConstructor
public class HomeController {
    private final ProviderTypeTemplateRepository providerTypeTemplateRepository;
    private final DynamicProviderService providerService;
    private final DynamicProviderRepository providerRepository;
    private final ApplicationRepository applicationRepository;
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;




    private final GroupsRepo groupsRepo;
    private final ProviderUserGroupsRepo providerUserGroupsRepo;
    private final GroupUsersRepo groupUsersRepo;
    private final JpaUserRepo jpaUserRepo;


    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/db")
    public String db(){
        return "redirect:/db";
    }


    @GetMapping("/provider")
    @ResponseBody
    public List<DynamicProvider> createProviderByTemplate(){
        DynamicProvider openId = providerService.createByTemplate(ProviderType.OPENID);
        DynamicProvider oauth = providerService.createByTemplate(ProviderType.OAUTH2);
        DynamicProvider ldap = providerService.createByTemplate(ProviderType.LDAP);
        providerRepository.saveAll(Arrays.asList(openId,oauth, ldap));
        return providerRepository.findAll();
    }

    @GetMapping("/app")
    @ResponseBody
    public Application createApplication(){
        JpaApplication application = new JpaApplication();
        application.setType(1L);
        application.setClientId("123");

        DynamicProvider openId = providerService.createByTemplate(ProviderType.OPENID);
        DynamicProvider oauth = providerService.createByTemplate(ProviderType.OAUTH2);
        DynamicProvider ldap = providerService.createByTemplate(ProviderType.LDAP);
        oauth.setApplication(application);
        openId.setApplication(application);
        ldap.setApplication(application);
        application.setProviders((Arrays.asList(openId,oauth, ldap)));
        applicationRepository.save(application);
        return application;
    }

    @GetMapping("/test")
    @ResponseBody
    public List<DynamicProvider> dynamicProvider(){
        Optional<JpaApplication> byId = applicationRepository.findById(1L);


        Map<String, String> map = new HashMap<String, String>() {{put("Dima", "28");}};
        map.forEach((key, value) -> System.out.println(key + "= " + value));
        return providerRepository.findDynamicProvidersByApplication_EntityId(1L);
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


    @GetMapping("/groups")
    @ResponseBody
    public void groups(){
        DynamicProvider provider1 =  DynamicProvider.builder().name("Provider1").type(ProviderType.OAUTH2).build();
        DynamicProvider provider2 =  DynamicProvider.builder().name("Provider2").type(ProviderType.SAML).build();

        providerRepository.save(provider1);
        providerRepository.save(provider2);

        Groups group1 = Groups.builder().name("group1").active(true).created(LocalDateTime.now()).usersNumber(5).build();
        Groups group2 = Groups.builder().name("group2").active(true).created(LocalDateTime.now()).usersNumber(10).build();

        groupsRepo.save(group1);
        groupsRepo.save(group2);

        JpaUser jpaUser1 = JpaUser.builder().username("Dima").build();
        JpaUser jpaUser2 = JpaUser.builder().username("Kola").build();
        JpaUser jpaUser3 = JpaUser.builder().username("Sasha").build();
        JpaUser jpaUser4 = JpaUser.builder().username("LOLo").build();

        jpaUserRepo.save(jpaUser1);
        jpaUserRepo.save(jpaUser2);
        jpaUserRepo.save(jpaUser3);
        jpaUserRepo.save(jpaUser4);

        ProviderUserGroups providerUserGroups1 = ProviderUserGroups.builder().groups(group1).groupType(ProviderUserGroups.GroupType.DEFAULT).dynamicProvider(provider1).build();
        ProviderUserGroups providerUserGroups2 = ProviderUserGroups.builder().groups(group1).groupType(ProviderUserGroups.GroupType.CUSTOM).dynamicProvider(provider2).build();


        providerUserGroupsRepo.save(providerUserGroups1);
        providerUserGroupsRepo.save(providerUserGroups2);


        GroupUsers groupUsers1 = GroupUsers.builder().person(jpaUser1).groups(group1).userRole(GroupUsers.Role.OWNER).build();
        GroupUsers groupUsers2 = GroupUsers.builder().person(jpaUser2).groups(group1).userRole(GroupUsers.Role.OWNER).build();
        GroupUsers groupUsers3 = GroupUsers.builder().person(jpaUser3).groups(group2).userRole(GroupUsers.Role.OWNER).build();
        GroupUsers groupUsers4 = GroupUsers.builder().person(jpaUser4).groups(group2).userRole(GroupUsers.Role.OWNER).build();

        groupUsersRepo.save(groupUsers1);
        groupUsersRepo.save(groupUsers2);
        groupUsersRepo.save(groupUsers3);
        groupUsersRepo.save(groupUsers4);

    }
}
