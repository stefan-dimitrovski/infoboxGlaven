package com.project.infobox.service.impl;

import com.project.infobox.repository.QuotesRepository;
import com.project.infobox.service.QuotesService;
import org.springframework.stereotype.Service;

@Service
public class QuotesServiceImpl implements QuotesService {

    private final QuotesRepository quotesRepository;

    public QuotesServiceImpl(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @Override
    public String getQuote() {
        return quotesRepository.getQuote();
    }
}
