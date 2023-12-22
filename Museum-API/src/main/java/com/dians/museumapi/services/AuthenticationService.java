package com.dians.museumapi.services;

import com.dians.museumapi.models.Role;
import com.dians.museumapi.models.User;
import com.dians.museumapi.repositories.RoleRepository;
import com.dians.museumapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User registerUser(String username, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        List<Role> authorities = new ArrayList<>();
        authorities.add(userRole);

        return userRepository.save(new User(0L, username, encodedPassword, authorities));
    }

    public String loginUser(String username, String password) {

        Optional<User> foundUser = userRepository.findByUsername(username);

        if (foundUser.isPresent() && passwordEncoder.matches(password, foundUser.get().getPassword())) {
            return "redirect:/museums";
        }

        return "redirect:/auth/login";
    }
}
