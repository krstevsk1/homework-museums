package com.dians.museumapi.services;

import com.dians.museumapi.models.User;
import com.dians.museumapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) {

        return userRepository.findByUsername(username).get();
    }
}
