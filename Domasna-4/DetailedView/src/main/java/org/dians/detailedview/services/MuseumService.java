package org.dians.detailedview.services;

import org.dians.detailedview.models.Museum;
import org.dians.detailedview.repositories.MuseumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MuseumService {
    @Autowired
    private MuseumRepo museumRepo;

    public List<Museum> searchMuseumsByName(String searchTerm) {
        Optional<List<Museum>> optionalMuseums = museumRepo.findByMuseumNameContainingIgnoreCase(searchTerm);
        return optionalMuseums.orElse(Collections.emptyList());
    }

    public Museum findMuseumById(Long museumId) {
        return museumRepo.findById(museumId).orElseThrow();
    }

    public List<Museum> findAll(){
        return museumRepo.findAll();
    }

}
