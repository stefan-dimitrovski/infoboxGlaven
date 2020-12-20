package com.project.infobox.repository;

import com.project.infobox.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {

    List<Amenity> findAmenityByAmenity(String amenity);

    @Query("select distinct u.amenity from Amenity u")
    List<String> findDistinctAmenityType();

    @Query(value = "SELECT * FROM amenity WHERE cuisine ILIKE %:items%", nativeQuery = true)
    List<Amenity> findByCuisine(@Param("items") String item);

    @Query(value = "SELECT * FROM amenity WHERE amenity = :amen AND cuisine ILIKE %:items%", nativeQuery = true)
    List<Amenity> findByCuisineAndAmenity(@Param("items") String item, @Param("amen") String amenity);

}
