package com.example.demo.regcontroller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.Login;
import com.example.demo.regservice.RegService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegController {
    @Autowired
    private RegService service;

    @GetMapping("/register")
    public String api() {
        return "register";
    }

    @PostMapping("/reg")
    public String login(@ModelAttribute("user") Login user) {
 
        Login oauthUser = service.saveUser(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/log";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/log")
    public String display() {
        return "dispReg";
    }
    

}