package com.dians.museumapi.controllers;

import com.dians.museumapi.models.RegistrationDTO;
import com.dians.museumapi.models.User;
import com.dians.museumapi.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword
    ) {
        if (!password.equals(confirmPassword)) {
            System.out.println("oopsie");
            return "redirect:/museums";
        }
        authenticationService.registerUser(username, password);

        return "redirect:/museums";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        return authenticationService.loginUser(username, password);
    }
}
