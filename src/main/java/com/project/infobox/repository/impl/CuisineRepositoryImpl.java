package com.project.infobox.repository.impl;

import com.project.infobox.model.Amenity;
import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.repository.CuisineRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class CuisineRepositoryImpl implements CuisineRepository {

    private final AmenityRepository amenityRepository;

    public CuisineRepositoryImpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    @Override
    public List<Amenity> findBySelectedItems(String items) {
        String[] params = items.split(";");
        List<Amenity> temp;
        Set resultArray = new HashSet();
        for (String item : params) {
            temp = amenityRepository.findByCuisine(item);
            resultArray.addAll(temp);
        }

        List<Amenity> resultArray2 = new ArrayList<>();
        resultArray2.addAll(resultArray);
        return resultArray2;
    }

    @Override
    public Set findBySelectedItemsAndAmenity(String items, String amenity) {
        String[] params = items.split(";");
        List<Amenity> temp;
        Set resultArray = new HashSet();
        for (String item : params) {
            temp = amenityRepository.findByCuisineAndAmenity(item, amenity);
            resultArray.addAll(temp);
        }

        return resultArray;
    }
}
