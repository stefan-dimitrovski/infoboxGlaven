package com.project.infobox.service;

import com.project.infobox.model.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {

    List<Feedback> findAll();

    Optional<Feedback> save(String userName,
                            String userEmail,
                            String userRating,
                            String userText);


}
