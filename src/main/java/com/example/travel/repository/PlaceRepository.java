package com.example.travel.repository;

import com.example.travel.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travel.model.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    List<Place> findAll();

    List<Place> findByName(String name);

    List<Place> findAllByType(Type type);

    List<Place> findAllByCity(String city);

    void deleteByName(String name);


    List<Place> findByTypeAndCity(Type type, String city);

    List<Place> findByNameAndCity(String name, String city);

    List<Place> findByNameAndType(String name, Type type);

    List<Place> findByNameAndTypeAndCity(String name, Type type, String city);
}
