package com.example.travel.service;

import com.example.travel.model.Guide;
import com.example.travel.model.Place;
import com.example.travel.model.Tour;
import com.example.travel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours(){
        return tourRepository.findAll();
    }

    public Tour getTourById(long id){
        return tourRepository.findById(id).orElse(null);
    }


    public List<Tour> getAllToursWithAverageRating() {
        List<Tour> tours = tourRepository.findAll();
        for (Tour tour : tours) {
            Double averageRating = tourRepository.getAverageTourRating(tour.getId());
            tour.setAverageRating(averageRating);
        }
        return tours;
    }

    public Tour getTourByName(String name){
        return tourRepository.findByName(name);
    }

    public List<Tour> getToursByPlaces(Place place){
        return tourRepository.findAllByPlaces(place);
    }


    public List<Tour> getToursOrderByPrice(){
        return tourRepository.findAllByOrderByPriceAsc();
    }

    public List<Tour> getToursByGuide (Guide guide){
        return tourRepository.findAllByGuide(guide);
    }


    public Tour createTour(Tour tour){
        return tourRepository.save(tour);
    }

    public void deleteTour (Long tourId){
        tourRepository.deleteById(tourId);
    }


}