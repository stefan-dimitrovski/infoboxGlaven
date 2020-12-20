package com.project.infobox.service.impl;

import com.project.infobox.model.Amenity;
import com.project.infobox.model.exception.AmenityNotFoundException;
import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.service.AmenityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository amenityRepository;

    public AmenityServiceImpl(AmenityRepository amenityRepository){
        this.amenityRepository = amenityRepository;
    }

    @Override
    public List<Amenity> findAll() {
        return this.amenityRepository.findAll();
    }

    @Override
    public Optional<Amenity> findById(Long id) {
        return Optional.of(this.amenityRepository.findById(id).orElseThrow(()-> new AmenityNotFoundException(id)));
    }

    @Override
    public List<String> findDistinctAmenityType() {
        return this.amenityRepository.findDistinctAmenityType();
    }

    @Override
    public List<Amenity> findAmenityByAmenity(String amenity) {
        return this.amenityRepository.findAmenityByAmenity(amenity);
    }
}
