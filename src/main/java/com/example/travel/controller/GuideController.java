package com.example.travel.controller;

import com.example.travel.model.Guide;
import com.example.travel.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/guides")
public class GuideController {

    private final GuideService guideService;

    @Autowired
    public GuideController(GuideService guideService) {
        this.guideService = guideService;
    }

    @GetMapping
    public String getAllGuides(Model model) {
        model.addAttribute("guides", guideService.getAllGuides());
        return "guides/list";
    }

    @GetMapping("/details/{id}")
    public String getGuideById(@PathVariable Long id, Model model) {
        Guide guide = guideService.getGuideById(id);
        model.addAttribute("guide", guide);
        return "guides/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("guide", new Guide());
        return "guides/create";
    }

    @PostMapping("/create")
    public String createGuide(@ModelAttribute Guide guide) {
        guideService.createGuide(guide);
        return "redirect:/guides";
    }

    @GetMapping("/{id}/delete")
    public String deleteGuide(@PathVariable Long id) {
        guideService.deleteGuide(id);
        return "redirect:/guides";
    }
}
