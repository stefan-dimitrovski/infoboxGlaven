package com.project.infobox.external;

import java.util.HashMap;

public class NameFormatter {
    private HashMap<String, String> nameList;

    public NameFormatter() {
        this.nameList = new HashMap<>();
        nameList.put("id", "ID_TEMP");
        nameList.put("lon", "LON_TEMP");
        nameList.put("lat", "LAT_TEMP");
        nameList.put("name", "Name: ");
        nameList.put("email", "Email: ");
        nameList.put("phone", "Phone: ");
        nameList.put("amenity", "Amenity: ");
        nameList.put("cuisine", "Cuisine: ");
        nameList.put("smoking", "Smoking: ");
        nameList.put("name_en", "Name eng: ");
        nameList.put("website", "Website: ");
        nameList.put("addr_city", "City address: ");
        nameList.put("addr_street", "Street address: ");
        nameList.put("addr_postcode", "Postcode: ");
        nameList.put("opening_hours", "Opening hours: ");
        nameList.put("outdoorseating", "Outdoor seating: ");
        nameList.put("addr_housenumber", "House number: ");
        nameList.put("wheelchair", "");
        nameList.put("building", "Building: ");
        nameList.put("drive_through", "Drive trough: ");
        nameList.put("shop", "Shop: ");
        nameList.put("takeaway", "Takeaway: ");
        nameList.put("internet_access", "Internet access: ");
        nameList.put("drive_in", "Drive-in: ");
        nameList.put("delivery", "Delivery: ");
        nameList.put("abandoned", "Abandoned: ");
        nameList.put("seasonal", "Seasonal: ");
        nameList.put("wifi", "Wi-Fi: ");
        nameList.put("operator", "Operator: ");
        nameList.put("organic", "Organic: ");
        nameList.put("payment_mastercard", "Mastercard: ");
        nameList.put("payment_visa", "Visa: ");
        nameList.put("capacity", "Capacity: ");
    }

    public String getName(String key) {
        return nameList.get(key);
    }
}
