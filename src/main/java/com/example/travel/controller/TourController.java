package com.example.travel.controller;

import com.example.travel.model.Tour;
import com.example.travel.repository.TourRepository;
import com.example.travel.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tours")
public class TourController {
    private final TourService tourService;
    private final TourRepository tourRepository;

    @Autowired
    public TourController(TourService tourService, TourRepository tourRepository) {
        this.tourService = tourService;
        this.tourRepository = tourRepository;
    }

    @GetMapping("/list")
    public String getAllTours(@RequestParam(defaultValue = "asc") String sort, Model model) {
        List<Tour> sortedTours;
        if (sort.equals("asc")) {
            sortedTours = tourRepository.findAllByOrderByPriceAsc();
        } else {
            sortedTours = tourRepository.findAllByOrderByPriceDesc();
        }
        model.addAttribute("tours", sortedTours);
        return "tours/list";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tour", new Tour());
        return "tours/create";
    }
    @PostMapping("/create")
    public String createPlace(@ModelAttribute Tour tour) {
        tourService.createTour(tour);
        return "redirect:/tours";
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        tourService.deleteTour(id);
        return "redirect:/places";
    }

    @GetMapping("/details/{id}")
    public String getTour(@PathVariable Long id, Model model) {
        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);

        return "tours/details";
    }
}


