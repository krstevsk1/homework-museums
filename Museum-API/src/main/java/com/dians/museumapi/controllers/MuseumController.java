package com.dians.museumapi.controllers;

import com.dians.museumapi.models.Museum;
import com.dians.museumapi.repositories.MuseumRepo;
import com.dians.museumapi.repositories.XmlToDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RequestMapping("/museums")
public class MuseumController {
    @Autowired
    private MuseumRepo museumRepo;
    @Autowired
    private XmlToDatabase xmlToDatabase;
    @GetMapping()
    public String getHomePage(Model model){
        xmlToDatabase.parseFiles();
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
