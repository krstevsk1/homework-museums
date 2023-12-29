package com.dians.museumapi.controllers;

import com.dians.museumapi.models.User;
import com.dians.museumapi.models.exception.InvalidArgumentException;
import com.dians.museumapi.models.exception.PasswordsDoNotMatchException;
import com.dians.museumapi.models.exception.UsernameAlreadyExistsException;
import com.dians.museumapi.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

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
        try {
            authenticationService.registerUser(username, password, confirmPassword);
            return "redirect:/auth/login";
        }
        catch (InvalidArgumentException | PasswordsDoNotMatchException | UsernameAlreadyExistsException exception) {
            return "redirect:/auth/register?error=" + exception.getMessage();
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request) {
        User user = null;

        try {
            user = authenticationService.loginUser(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
        } catch (InvalidArgumentException | NoSuchElementException  exception ) {
            return "redirect:/auth/login?error="+exception.getMessage();
        }

        return "redirect:/museums";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/auth/login";
    }
}
