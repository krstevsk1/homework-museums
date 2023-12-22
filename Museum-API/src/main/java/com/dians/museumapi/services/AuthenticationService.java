package com.dians.museumapi.services;

import com.dians.museumapi.models.User;
import com.dians.museumapi.models.exception.InvalidArgumentException;
import com.dians.museumapi.models.exception.PasswordsDoNotMatchException;
import com.dians.museumapi.models.exception.UsernameAlreadyExistsException;
import com.dians.museumapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public User registerUser(String username, String password, String confirmPassword) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        if (!password.equals(confirmPassword)){
            throw new PasswordsDoNotMatchException();
        }

        if (!userRepository.findByUsername(username).isEmpty()){
            throw new UsernameAlreadyExistsException(username);
        }

        User user = new User(username,password);
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {

        User foundUser = userService.loadUserByUsername(username);

        if (foundUser != null && !password.equals(foundUser.getPassword())) {

            throw new InvalidArgumentException();
        }

        return foundUser;
    }
}
