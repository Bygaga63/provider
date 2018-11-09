package com.job.dynamicproviders.controller;

import com.job.dynamicproviders.interfaces.Application;
import com.job.dynamicproviders.model.post.Post;
import com.job.dynamicproviders.model.post.PostComment;
import com.job.dynamicproviders.model.post.PostCommentRepository;
import com.job.dynamicproviders.model.post.PostRepository;
import com.job.dynamicproviders.model.providers.DynamicProvider;
import com.job.dynamicproviders.model.JpaApplication;
import com.job.dynamicproviders.model.providers.ProviderType;
import com.job.dynamicproviders.model.providers.ProviderTypeTemplate;
import com.job.dynamicproviders.repository.ApplicationRepository;
import com.job.dynamicproviders.repository.DynamicProviderRepository;
import com.job.dynamicproviders.repository.ProviderTypeTemplateRepository;
import com.job.dynamicproviders.service.DynamicProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping
    public String db(){
        return "redirect:/db";
    }

    @GetMapping("/template")
    @ResponseBody
    public ProviderTypeTemplate providerTypeTemplate(){
        return providerTypeTemplateRepository.findByType(ProviderType.OPENID);
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


    @GetMapping("test2")
    @ResponseBody
    public List<PostComment> test2(){
        Post post = new Post("First post");

        PostComment myFirstReview = new PostComment("My first review");
        myFirstReview.setPost(post);
        PostComment my_second_review = new PostComment("My second review");
        my_second_review.setPost(post);
        PostComment my_third_review = new PostComment("My third review");
        my_third_review.setPost(post);

        postRepository.save(post);
        postCommentRepository.saveAll(Arrays.asList(myFirstReview, my_second_review, my_third_review));
        return postCommentRepository.findMany();
    }
}
