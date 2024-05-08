package com.example.springrev.Controllers;


import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {
    @GetMapping("/profile")
    public String authentication(Authentication authentication, Model model){
        return authentication.toString();
    }
}
