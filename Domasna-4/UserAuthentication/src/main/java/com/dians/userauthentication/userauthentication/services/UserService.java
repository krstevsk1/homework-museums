package com.dians.userauthentication.userauthentication.services;

import com.dians.userauthentication.userauthentication.models.*;
import com.dians.userauthentication.userauthentication.models.exception.*;
import com.dians.userauthentication.userauthentication.repositories.MuseumRepo;
import com.dians.userauthentication.userauthentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MuseumRepo museumRepo;

    public User loadUserByUsername(String username) {

        return userRepository.findByUsername(username).get();
    }

    public void addMuseumToUser(Long museumId, String username){
        if (museumId != null && username != null){
            User user = userRepository.findByUsername(username).get();
            Museum museum = museumRepo.findById(museumId).get();
            if (user.getMuseums().contains(museum)){
                return;
            }
            user.getMuseums().add(museum);
            userRepository.save(user);
        }
    }

    public void removeMuseumFromUser(Long museumId, String username){
        if (museumId != null && username != null){
            User user = userRepository.findByUsername(username).get();
            Museum museum = museumRepo.findById(museumId).get();
            user.getMuseums().remove(museum);
            userRepository.save(user);
        }
    }

}
