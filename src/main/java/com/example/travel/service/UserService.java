package com.example.travel.service;

import com.example.travel.model.Tour;
import com.example.travel.model.User;
import com.example.travel.repository.UserRepository;
import com.example.travel.repository.TourRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private TourRepository tourRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser (Long userId){
        userRepository.deleteById(userId);

    }
    private BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    public void saveUser(User user) {
        user.setPassword(encoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getCurrentLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof User) {
                return (User) principal;
            }
        }
        return null; //
    }


    public void addTourToUser(Long userId, Long tourId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Tour> optionalTour = tourRepository.findById(tourId);

        User user = optionalUser.get();
        Tour tour = optionalTour.get();


        user.getTours().add(tour);
        tour.setFreeSpots(tour.getFreeSpots() - 1);
        userRepository.save(user);
    }
}


