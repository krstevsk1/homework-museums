package com.dians.userauthentication.userauthentication.services;
import com.dians.userauthentication.userauthentication.models.*;
import com.dians.userauthentication.userauthentication.repositories.UserRepository;
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
