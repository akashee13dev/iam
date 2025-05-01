package com.akash.authentication.controller;

import com.akash.authentication.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class PageController {


    @GetMapping("/test")
    public String test(){
        return "Connected successfully";
    }

    @GetMapping("/home")
    public String showHomePage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "home";
        }
        return "redirect:/req/signin";
    }

    @GetMapping("/req/signin")
    public String showLoginPage() {
        return "signin";
    }


    @GetMapping("/req/signup")
    public String showCreatPage() {
        return "signup";
    }

}
