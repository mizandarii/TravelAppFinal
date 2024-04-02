package com.example.travel.controller;

import com.example.travel.model.Review;
import com.example.travel.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class ReviewController {
    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping
    public String getAllGuides(Model model) {
        model.addAttribute("user", reviewService.getAllReviews());
        return "reviews/list";
    }
    @GetMapping("/{id}")
    public String getGuideById(@PathVariable Long id, Model model) {
        Review review = reviewService.getReviewById(id);
        model.addAttribute("review", review);
        return "reviews/details";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviews/create";
    }
    @PostMapping("/create")
    public String createReview(@ModelAttribute Review review) {
        reviewService.createReview(review);
        return "redirect:/reviews";
    }
    @GetMapping("/{id}/delete")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/reviews";
    }
}


