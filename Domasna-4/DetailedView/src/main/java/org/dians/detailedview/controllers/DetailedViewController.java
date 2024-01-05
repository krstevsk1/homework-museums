package org.dians.detailedview.controllers;

import org.dians.detailedview.models.Museum;
import org.dians.detailedview.services.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detailed")
public class DetailedViewController {

    @Autowired
    private MuseumService museumService;

    @GetMapping("/{id}")
    public String getDetailedMuseum(@PathVariable Long id, Model model){
        Museum museum = museumService.findMuseumById(id);
        model.addAttribute("museum", museum);
        return "detailsMuseum";
    }
}
