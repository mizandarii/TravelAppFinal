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
            // User is not authenticated, handle the scenario accordingly
            // For example, you can redirect the user to the login page
            return "redirect:/login";
        }

        User currentUser = userService.getCurrentLoggedInUser();
        if (currentUser == null) {
            // Handle the scenario when the current user is null
            // For example, display an error message or redirect to an error page
            return "redirect:/error";
        }

        // Proceed with adding the tour to the user
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



