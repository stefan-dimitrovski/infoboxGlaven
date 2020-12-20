package com.project.infobox.repository;

import com.project.infobox.model.Amenity;

import java.util.List;
import java.util.Set;

public interface CuisineRepository {
    List<Amenity> findBySelectedItems(String items);
    Set findBySelectedItemsAndAmenity(String items, String amenity);
}
