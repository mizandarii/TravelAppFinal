package com.example.travel.controller;

import com.example.travel.model.User;
import com.example.travel.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/list";
    }
    @GetMapping("/viewUserinfo/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/viewUserinfo";
    }



    @Transactional
    @PostMapping("/addTourToUser")
    public String addTourToUser(@RequestParam Long tourId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }

        User currentUser = userService.getCurrentLoggedInUser();
        if (currentUser == null) {
            return "redirect:/error";
        }

        userService.addTourToUser(currentUser.getId(), tourId);
        model.addAttribute("user", currentUser);
        return "redirect:/tours/list";
    }





    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }




    }



