package com.project.infobox.web.rest;

import com.project.infobox.model.Amenity;
import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.repository.CuisineRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class GetDataController {

    private final AmenityRepository amenityRepository;
    private final CuisineRepository cuisineRepository;


    public GetDataController(AmenityRepository amenityRepository, CuisineRepository cuisineRepository) {
        this.amenityRepository = amenityRepository;
        this.cuisineRepository = cuisineRepository;
    }

    @GetMapping
    @ResponseBody
    public Optional<Amenity> getLocationData(@RequestParam Long id) {
        return amenityRepository.findById(id);
    }

    @GetMapping("/amenity")
    @ResponseBody
    public List<Amenity> getAmenityData(@RequestParam String type) {
        return amenityRepository.findAmenityByAmenity(type);
    }

    @GetMapping("/table")
    @ResponseBody
    public List<Amenity> getItemsData(@RequestParam String items) {
        return cuisineRepository.findBySelectedItems(items);
    }
}
