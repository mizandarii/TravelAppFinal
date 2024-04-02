package com.example.travel.controller;

import com.example.travel.model.Transport;
import com.example.travel.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class TransportController {
    private final TransportService transportService;
    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }
    @GetMapping
    public String getAllTransport(Model model) {
        model.addAttribute("user", transportService.getAllTransport());
        return "transport/list";
    }
    @GetMapping("/{id}")
    public String getTransportById(@PathVariable Long id, Model model) {
        Transport transport = transportService.getTransportById(id);
        model.addAttribute("review", transport);
        return "transpot/details";
    }
    @GetMapping("/create")
    public String showTransportForm(Model model) {
        model.addAttribute("review", new Transport());
        return "transport/create";
    }
    @PostMapping("/create")
    public String createReview(@ModelAttribute Transport transport) {
        transportService.createTransport(transport);
        return "redirect:/transport";
    }
    @GetMapping("/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        transportService.deleteTransport(id);
        return "redirect:/reviews";
    }
}


