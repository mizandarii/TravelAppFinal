package com.example.travel.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.travel.model.User;
import com.example.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/loginNew")
    public String showLoginPage() {
        return "loginNew";
    }

    @PostMapping("/loginNew")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        User user = userService.getUserByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            if (user.getId() != null) {
                return "redirect:/users/viewUserinfo/" + user.getId();
            } else {
                System.out.println("user is null");
                return "index";
            }
        } else {
            model.addAttribute("error", true);
            return "loginNew";
        }
    }



}
