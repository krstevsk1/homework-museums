package com.dians.userauthentication.userauthentication.controllers;

import com.dians.userauthentication.userauthentication.models.exception.InvalidArgumentException;
import com.dians.userauthentication.userauthentication.models.exception.PasswordsDoNotMatchException;
import com.dians.userauthentication.userauthentication.models.exception.UsernameAlreadyExistsException;
import com.dians.userauthentication.userauthentication.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/ms")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmPassword
    ) {
        try {
            authenticationService.registerUser(username, password, confirmPassword);
            return "redirect:/auth/ms/login";
        } catch (InvalidArgumentException | PasswordsDoNotMatchException | UsernameAlreadyExistsException exception) {
            return "redirect:/auth/ms/register?error=" + exception.getMessage();
            //return "redirect:/auth/ms/register";
        }
    }

    


}
