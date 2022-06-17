package com.example.graphql.service;

import com.example.graphql.data.Quote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuoteService {
    public Quote getQuote(String site) {
        LongOperation.simulate(Optional.of(1_000));
        var random = new Random();
        var price = 100 + random.nextInt(10);
        return new Quote(site, price);
    }

    public List<Quote> getQuotes() {
        var sites = List.of("site1", "site2", "site3");
        return sites.stream().map(this::getQuote).toList();
    }
}
