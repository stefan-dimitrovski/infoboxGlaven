package com.project.infobox.web.controller;

import com.project.infobox.service.AmenityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class AmenityController {

    private final AmenityService amenityService;

    public AmenityController(AmenityService amenityService){
        this.amenityService = amenityService;
    }

    @GetMapping
    public String getAmenityPage(Model model){
        model.addAttribute("amenityTypes", this.amenityService.findDistinctAmenityType());
        model.addAttribute("amenities", this.amenityService.findAll());

        return "listAmenities";
    }

    @PostMapping("/amenityType")
    public String getAmenityByType(@RequestParam String type, Model model){
        model.addAttribute("amenityTypes", this.amenityService.findDistinctAmenityType());
        model.addAttribute("amenities", this.amenityService.findAmenityByAmenity(type));

        return "listAmenities";
    }


}
