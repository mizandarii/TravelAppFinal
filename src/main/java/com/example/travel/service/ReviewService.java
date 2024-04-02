package com.example.travel.service;

import com.example.travel.model.Review;
import com.example.travel.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReviewById(long id){
        return reviewRepository.findById(id).orElse(null);
    }

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteReview (Long reviewId){
        reviewRepository.deleteById(reviewId);
    }


}