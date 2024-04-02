package com.example.travel.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transport")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String type;


    @Column(length = 50)
    private String firma;


    @Column
    private String details;


    //уровень комфорта по пятибалльной шкале
    @Column
    private int comfort;


    @OneToMany(mappedBy="transport")
    private List<Tour> tours;

}