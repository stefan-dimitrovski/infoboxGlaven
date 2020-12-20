package com.project.infobox.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about_us")
public class AboutUsController {

    @GetMapping // localhost:8080/about_us
    public String getAboutUsPage() {
        return "about_us";
    }
}
