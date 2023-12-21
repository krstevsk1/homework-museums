package com.dians.museumapi.controllers;

import com.dians.museumapi.models.Museum;
import com.dians.museumapi.repositories.MuseumRepo;
import com.dians.museumapi.services.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/museums")
@CrossOrigin("*")
public class MuseumController {
    @Autowired
    private MuseumRepo museumRepo;
    @Autowired
    private MuseumService museumService;
    @GetMapping()
    public String getHomePage(Model model){
        museumService.parseFiles();
        model.addAttribute("museumList", museumRepo.findAll());
        return "index";
    }

    @GetMapping("/detailedMuseum/{id}")
    public String getDetailedMuseum(@PathVariable Long id, Model model){
        if (museumRepo.findById(id).isPresent()){
            Museum museum = museumRepo.findById(id).get();
            model.addAttribute("museum", museum);
            return "detailsMuseum";
        }
        return "redirect:/museums";
    }
}
