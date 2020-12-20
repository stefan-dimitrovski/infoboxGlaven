package com.project.infobox.web.controller;

import com.project.infobox.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService){
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public String saveFeedback(@RequestParam String experience,
                               @RequestParam String comments,
                               @RequestParam String name,
                               @RequestParam String email)
    {
        this.feedbackService.save(name, email, experience, comments);

        return "redirect:about_us";
    }
}
