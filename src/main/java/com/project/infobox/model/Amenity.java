package com.project.infobox.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Amenity {

    @Id
    private Long id;

    private double lon;

    private double lat;

    private String name;

    private String email;

    private String phone;

    private String amenity;

    private String cuisine;

    private String smoking;

    private String name_en;

    private String website;

    private String addr_city;

    private String addr_street;

    private String addr_postcode;

    private String opening_hours;

    private String outdoorseating;

    private String addr_housenumber;

    private String wheelchair;

    private String building;

    private String drive_through;

    private String shop;

    private String takeaway;

    private String internet_access;

    private String drive_in;

    private String delivery;

    private String abandoned;

    private String seasonal;

    private String wifi;

    private String operator;

    private String organic;

    private String payment_mastercard;

    private String payment_visa;

    private Integer capacity;

    public Amenity(Long id, double lon, double lat, String name, String email, String phone, String amenity, String cuisine, String smoking, String name_en, String website, String addr_city, String addr_street, String addr_postcode, String opening_hours, String outdoorseating, String addr_housenumber, String wheelchair, String building, String drive_through, String shop, String takeaway, String internet_access, String drive_in, String delivery, String abandoned, String seasonal, String wifi, String operator, String organic, String payment_mastercard, String payment_visa, Integer capacity) {
        this.id = id;
        this.lon = lon;
        this.lat = lat;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.amenity = amenity;
        this.cuisine = cuisine;
        this.smoking = smoking;
        this.name_en = name_en;
        this.website = website;
        this.addr_city = addr_city;
        this.addr_street = addr_street;
        this.addr_postcode = addr_postcode;
        this.opening_hours = opening_hours;
        this.outdoorseating = outdoorseating;
        this.addr_housenumber = addr_housenumber;
        this.wheelchair = wheelchair;
        this.building = building;
        this.drive_through = drive_through;
        this.shop = shop;
        this.takeaway = takeaway;
        this.internet_access = internet_access;
        this.drive_in = drive_in;
        this.delivery = delivery;
        this.abandoned = abandoned;
        this.seasonal = seasonal;
        this.wifi = wifi;
        this.operator = operator;
        this.organic = organic;
        this.payment_mastercard = payment_mastercard;
        this.payment_visa = payment_visa;
        this.capacity = capacity;
    }

    public Amenity() {

    }
}
