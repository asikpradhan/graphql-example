package com.example.graphql.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quote {
    private String site;
    private int price;

    @Override
    public String toString() {
        return "Quote{site='" + site + '\'' + ", price=" + price + '}';
    }
}
