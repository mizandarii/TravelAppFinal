package com.example.travel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false)
    private LocalDate start;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column
    private int spots;

    @Column
    private int freeSpots;

    @Column(nullable = false)
    private double price;


    @ManyToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @Column
    private Double averageRating;

    @ManyToMany
    @JoinTable(
            name = "tour_place",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private List<Place> places;


    @ManyToOne
    @JoinColumn(name="transport_id", nullable=false)
    private Transport transport;


    @ManyToMany
    @JoinTable(
            name = "user_tour",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;




}