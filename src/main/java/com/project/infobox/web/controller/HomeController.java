package com.project.infobox.web.controller;

import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.repository.CuisineRepository;
import com.project.infobox.service.LocationService;
import com.project.infobox.service.QuotesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    private final QuotesService quotesService;
    private final LocationService locationService;
    private final AmenityRepository amenityRepository;
    private final CuisineRepository cuisineRepository;

    public HomeController(QuotesService quotesService, LocationService locationService, AmenityRepository amenityRepository, CuisineRepository cuisineRepository) {
        this.quotesService = quotesService;
        this.locationService = locationService;
        this.amenityRepository = amenityRepository;
        this.cuisineRepository = cuisineRepository;
    }

    @GetMapping // localhost:8080/
    public String getHomePage(HttpServletRequest request, Model model) {
        model.addAttribute("quote", quotesService.getQuote());
        model.addAttribute("hasTable", false);
        return "index";
    }

    @PostMapping
    public String postMethod(HttpServletRequest request, Model model) {
        // vrednostite od search se prakjaat na ime searchItems
        model.addAttribute("quote", quotesService.getQuote());
        model.addAttribute("hasTable", true);
        System.out.println(request.getParameter("searchItems"));
        model.addAttribute("items", request.getParameter("searchItems"));
        model.addAttribute("tableData", cuisineRepository.findBySelectedItems(request.getParameter("searchItems")));
        return "index";
    }











}
