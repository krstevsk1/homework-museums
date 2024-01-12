package com.dians.userauthentication.userauthentication.services;
import com.dians.userauthentication.userauthentication.models.*;
import com.dians.userauthentication.userauthentication.models.exception.*;
import com.dians.userauthentication.userauthentication.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
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
        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(username,encPassword);
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User foundUser = userService.loadUserByUsername(username);
        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        if (foundUser == null && !BCrypt.checkpw(password,encPassword)) {
            throw new InvalidArgumentException();
        }

        return foundUser;
    }
}
