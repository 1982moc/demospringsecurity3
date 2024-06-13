package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.models.User;

import com.example.demospringsecurity.service.UserService;
import com.example.demospringsecurity.service.security.AccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        User user = accountDetails.getUser();
        System.out.println("User: " + user);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/")
    public String home() {
        if (userService.listUsers().isEmpty())
            userService.addUser(new User("admin", "admin", Arrays.asList("ROLE_ADMIN")));
        return "index";
    }

    @RequestMapping("/forbidden")
    public String accessDenied() {
        return "forbidden";
    }
}