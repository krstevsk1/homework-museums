package com.dians.museumapi.controllers;

import com.dians.museumapi.models.Museum;
import com.dians.museumapi.repositories.MuseumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/museums")
public class MuseumController {

    @Autowired
    private MuseumRepo museumRepo;

    @GetMapping(path = "")
    public List<Museum> getAllMuseums() {

        return museumRepo.findAll();
    }

    @GetMapping(path = "/museums/{id}")
    public Museum getMuseumById(@PathVariable("id") Long id) {

        return museumRepo.findById(id).orElseThrow();
    }
}
