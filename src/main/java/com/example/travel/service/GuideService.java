package com.example.travel.service;

import com.example.travel.model.Guide;
import com.example.travel.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {
    @Autowired
    private GuideRepository guideRepository;

    public List<Guide> getAllGuides(){
        return guideRepository.findAll();
    }

    public Guide getGuideById(long id){
        return guideRepository.findById(id).orElse(null);
    }

    public Guide createGuide(Guide guide){
        return guideRepository.save(guide);
    }

    public void deleteGuide (Long guideId){
        guideRepository.deleteById(guideId);
    }


}