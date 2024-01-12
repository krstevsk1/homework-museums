package com.dians.museumapi.controllers;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "redirect:http://localhost:8081/auth/ms/register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "redirect:http://localhost:8081/auth/ms/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/auth/login";
    }
}
