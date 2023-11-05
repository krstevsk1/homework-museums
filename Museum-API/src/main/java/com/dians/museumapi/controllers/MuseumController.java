package com.dians.museumapi.controllers;

import com.dians.museumapi.models.Museum;
import com.dians.museumapi.repositories.MuseumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MuseumController {
//hello
    @Autowired
    private MuseumRepo museumRepo;

    @GetMapping(path = "/museums")
    public List<Museum> getAllMuseums() {
        return museumRepo.findAll();
    }
}
