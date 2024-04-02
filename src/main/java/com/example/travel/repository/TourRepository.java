package com.example.travel.repository;

import com.example.travel.model.Guide;
import com.example.travel.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travel.model.Tour;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findAllByPlaces(Place place);


    Tour findByName(String name);

    List <Tour> findAllByGuide(Guide guide);

    //List<Tour> findAllByOrderByUsers();

    //@Query("SELECT t FROM Tour t JOIN t.users u GROUP BY t.id ORDER BY COUNT(u) DESC")
    //List<Tour> findAllOrderByUserCount();

    List<Tour> findAllByOrderByPriceAsc();

    List<Tour> findAllByOrderByPriceDesc();

    @Query("SELECT AVG(r.rating) FROM Tour t JOIN t.reviews r WHERE t.id = :id")
    Double getAverageTourRating(@Param("id") Long id);

    //Double getAverageRatingById(Long tourId);

}