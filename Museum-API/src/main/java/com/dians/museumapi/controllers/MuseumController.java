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
        User user = getUser(request);
        model.addAttribute("user", user);
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
        User user = getUser(req);
        if (checkForUserInSession(user)){
            return "redirect:/auth/login";
        }
        Museum museum = museumService.findMuseumById(museumId);
        userService.addMuseumToUser(museum.getMuseumId(), user.getUsername());
        return "redirect:/museums";
    }

    @PostMapping("/removeFromFavorites/{museumId}")
    public String removeMuseumToUser(@PathVariable Long museumId, HttpServletRequest req){
        User user = getUser(req);
        if (checkForUserInSession(user)){
            return "redirect:/auth/login";
        }
        Museum museum = museumService.findMuseumById(museumId);
        userService.removeMuseumFromUser(museum.getMuseumId(), user.getUsername());
        return "redirect:/museums";
    }

    @GetMapping("/myMuseums")
    public String getMyMuseums(HttpServletRequest req, Model model){
        User user = getUser(req);
        if (checkForUserInSession(user)){
            return "redirect:/auth/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("museums", user.getMuseums());
        return "my-museums";
    }

    @GetMapping("/search")
    public String searchMuseums(@RequestParam(name = "searchTerm") String searchTerm, Model model, HttpServletRequest req) {
        List<Museum> searchResults = museumService.searchMuseumsByName(searchTerm);
        User user = getUser(req);
        model.addAttribute("user", user);
        model.addAttribute("museumList", searchResults);
        return "index";
    }

    // zemi go korisnikot vo sesija
    // ako ne e vo sesija kreiraj prazen User(). Simulira user guest
    private User getUser(HttpServletRequest req){
        User userInSession = (User) req.getSession().getAttribute("user");
        return userInSession != null ? userService.loadUserByUsername(userInSession.getUsername()) : new User();
    }

    private boolean checkForUserInSession(User user){
        return user.getUsername() == null || user.getUsername().isEmpty();
    }

}
