package com.job.dynamicproviders.web.controller;

import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserRepository userRepo;

    @GetMapping
    public String showCreateUserView(Model model){
        model.addAttribute("user", new JpaUser());
        return "userCreate";
    }

    @PostMapping
    public String createUser(@ModelAttribute JpaUser user, Model model){
        userRepo.save(user);
        List<JpaUser> userList = userRepo.findAll();
        model.addAttribute("userList", userList);
        return "userResult";

    }
}
