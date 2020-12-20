package com.project.infobox.web.controller;

import com.project.infobox.repository.AmenityRepository;
import com.project.infobox.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/explore")
public class ExploreController {

    public final LocationService locationService;
    public final AmenityRepository amenityRepository;

    public ExploreController(LocationService locationService, AmenityRepository amenityRepository) {
        this.locationService = locationService;
        this.amenityRepository = amenityRepository;
    }

    // localhost:8080/explore?id={optional}
    @GetMapping
    public String getExplorePage(HttpServletRequest request, Model model, @RequestParam(value = "id", required = false) Long id) {
        if (request.getSession().getAttribute("userLocation") == null) {
            request.getSession().setAttribute("userLocation", locationService.getLatLonFromIP(request));
        }
        if (id != null) {
            model.addAttribute("locationInfo", amenityRepository.findById(id));
            model.addAttribute("hasId", true);
            model.addAttribute("id", id);
        }
        else { // ova e za dali da go krie Choose amenity ako e dadeno ID
            model.addAttribute("hasId", false);
        }
        model.addAttribute("userLocation", request.getSession().getAttribute("userLocation"));
        return "explore";
    }
}
