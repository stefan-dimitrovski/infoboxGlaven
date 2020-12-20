package com.project.infobox.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.infobox.service.LocationService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private String access_key = "fffe5a2f8df1461b39b6d7151542608d";

    public LocationServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Double[] getLatLonFromIP(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        try {
            Map<String, ? extends Double> map = objectMapper.readValue(
                restTemplate.getForObject(
                        String.format("http://api.ipstack.com/%s?access_key=%s&format=1", ip, access_key), String.class
                ), Map.class
            );
            Double[] latlon = new Double[] { map.get("latitude"), map.get("longitude") };
            return latlon;
        }
        catch (JsonProcessingException exception) {
            System.out.printf(exception.getMessage());
        }
        return null;
    }
}
