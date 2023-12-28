package com.dians.museumapi.controllers;

import com.dians.museumapi.models.Museum;
import com.dians.museumapi.models.User;
import com.dians.museumapi.repositories.MuseumRepo;
import com.dians.museumapi.services.MuseumService;
import com.dians.museumapi.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/museums")
@CrossOrigin("*")
public class MuseumController {
    @Autowired
    private MuseumService museumService;
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getHomePage(HttpServletRequest request, Model model){
        museumService.parseFiles();
        User user = (User) request.getSession().getAttribute("user");
        User user2 = new User();
        if (user != null){
            user2 = userService.loadUserByUsername(user.getUsername());
        }
        model.addAttribute("user", user2);
        model.addAttribute("museumList", museumService.findAll());
        return "index";
    }

    @GetMapping("/detailedMuseum/{id}")
    public String getDetailedMuseum(@PathVariable Long id, Model model){
        Museum museum = museumService.findMuseumById(id);
        model.addAttribute("museum", museum);
        return "detailsMuseum";
    }

    @PostMapping("/addToFavorites/{museumId}")
    public String addMuseumToUser(@PathVariable Long museumId, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/auth/login";
        }
        Museum museum = museumService.findMuseumById(museumId);
        userService.addMuseumToUser(museum.getMuseumId(), user.getUsername());
        return "redirect:/museums";
    }

    @PostMapping("/removeFromFavorites/{museumId}")
    public String removeMuseumToUser(@PathVariable Long museumId, HttpServletRequest req){
        Museum museum = museumService.findMuseumById(museumId);
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/auth/login";
        }
        userService.removeMuseumFromUser(museum.getMuseumId(), user.getUsername());
        return "redirect:/museums";
    }

    @GetMapping("/myMuseums")
    public String getMyMuseums(HttpServletRequest req, Model model){
        User user = (User) req.getSession().getAttribute("user");
        User user2 = new User();
        if (user != null){
            user2 = userService.loadUserByUsername(user.getUsername());
        }
        if (user == null){
            return "redirect:/auth/login";
        }
        model.addAttribute("user", user2);
        model.addAttribute("museums", user2.getMuseums());
        return "my-museums";
    }

    @GetMapping("/search")
    public String searchMuseums(@RequestParam(name = "searchTerm") String searchTerm, Model model, HttpServletRequest req) {
        List<Museum> searchResults = museumService.searchMuseumsByName(searchTerm);
        model.addAttribute("museumList", searchResults);
        User user = (User) req.getSession().getAttribute("user");
        User user2 = new User();
        if (user != null){
            user2 = userService.loadUserByUsername(user.getUsername());
        }
        model.addAttribute("user", user2);
        return "index";
    }
}
