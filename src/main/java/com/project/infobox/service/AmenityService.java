package com.project.infobox.service;

import com.project.infobox.model.Amenity;

import java.util.List;
import java.util.Optional;

public interface AmenityService {

    List<Amenity> findAll();

    Optional<Amenity> findById(Long id);

    List<String> findDistinctAmenityType();

    List<Amenity> findAmenityByAmenity(String amenity);
}
