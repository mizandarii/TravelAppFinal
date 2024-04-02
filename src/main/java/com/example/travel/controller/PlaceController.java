package com.example.travel.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.travel.model.Place;
import com.example.travel.model.Type;
import com.example.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places/list")
    public String getPlaces(Model model,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String city,
                            @RequestParam(required = false) Type type) {
        List<Place> places;

        if (name != null && !name.isEmpty()) {
            if (type != null && city != null && !city.isEmpty()) {
                places = placeService.findPlacesByNameAndTypeAndCity(name, type, city);
            } else if (city != null && !city.isEmpty()) {
                places = placeService.findPlacesByNameAndCity(name, city);
            } else if (type != null) {
                places = placeService.findPlacesByNameAndType(name, type);
            } else {
                places = placeService.findPlacesByName(name);
            }
        } else if (city != null && !city.isEmpty()) {
            if (type != null) {
                places = placeService.findPlacesByTypeAndCity(type, city);
            } else {
                places = placeService.findPlacesByCity(city);
            }
        } else if (type != null) {
            places = placeService.findPlacesByType(type);
        } else {
            places = placeService.findAllPlaces();
        }

        List<Type> types = placeService.getAllTypes();
        model.addAttribute("types", types);

        model.addAttribute("places", places);
        return "places/list";
    }



    @GetMapping("/places/details/{id}")
    public String getPlaceDetails(Model model, @PathVariable Long id) {
        Place place = placeService.findPlaceById(id);
        model.addAttribute("place", place);
        return "places/details";
    }

}
