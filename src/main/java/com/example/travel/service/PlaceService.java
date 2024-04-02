package com.example.travel.service;

import com.example.travel.model.Type;
import com.example.travel.repository.PlaceRepository;
import com.example.travel.model.Place;
import com.example.travel.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

 private final PlaceRepository placeRepository;
 private final TypeRepository typeRepository;

 @Autowired
 public PlaceService(PlaceRepository placeRepository, TypeRepository typeRepository) {
  this.placeRepository = placeRepository;
  this.typeRepository = typeRepository;
 }



 public List<Place> findAllPlaces() {
  return placeRepository.findAll();
 }
 public List<Place> findPlacesByName(String name) {
  return placeRepository.findByName(name);
 }

 public List<Place> findPlacesByType(Type type) {
  return placeRepository.findAllByType(type);
 }

 public List<Place> findPlacesByCity(String city) {
  return placeRepository.findAllByCity(city);
 }

 public List<Place> findPlacesByTypeAndCity(Type type, String city) {
  return placeRepository.findByTypeAndCity(type, city);
 }

 public List<Place> findPlacesByNameAndCity(String name, String city) {
  return placeRepository.findByNameAndCity(name, city);
 }

 public List<Place> findPlacesByNameAndType(String name, Type type) {
  return placeRepository.findByNameAndType(name, type);
 }

 public List<Place> findPlacesByNameAndTypeAndCity(String name, Type type, String city) {
  return placeRepository.findByNameAndTypeAndCity(name, type, city);
 }

 public Place findPlaceById(Long id) {
  return placeRepository.getById(id);
 }

 public List<Type> getAllTypes() {
  return typeRepository.findAll();
 }
}
