package com.project.infobox.service.impl;

import com.project.infobox.model.Feedback;
import com.project.infobox.repository.FeedbackRepository;
import com.project.infobox.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> findAll() {
        return this.feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> save(String userName, String userEmail, String userRating, String userText) {
        return Optional.of(this.feedbackRepository.save(new Feedback(userName, userEmail, userRating, userText)));
    }
}
