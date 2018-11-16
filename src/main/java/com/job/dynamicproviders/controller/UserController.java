package com.job.dynamicproviders.controller;

import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.repository.JpaUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private JpaUserRepo userRepo;

    @GetMapping
    public String showCreateUser(Model model){
        model.addAttribute("user", new JpaUser());
        return "userCreate";
    }

    @PostMapping
    public String createUser(@ModelAttribute JpaUser user, Model model){

        model.addAttribute("user", user);
        return "userResult";

    }
}
