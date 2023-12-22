package com.dians.museumapi.services;

import com.dians.museumapi.models.Role;
import com.dians.museumapi.models.User;
import com.dians.museumapi.repositories.RoleRepository;
import com.dians.museumapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    public User registerUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        List<Role> authorities = new ArrayList<>();
        authorities.add(userRole);

        return userRepository.save(new User(0L, username, encodedPassword, authorities));
    }

    public String loginUser(String username, String password) {

        UserDetails foundUser = userService.loadUserByUsername(username);

        if (foundUser != null && passwordEncoder.matches(password, foundUser.getPassword())) {
            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            } catch(AuthenticationException e){
                System.out.println(e);
                return "redirect:/auth/login";
            }
            return "redirect:/museums";
        }

        return "redirect:/auth/login";
    }
}
