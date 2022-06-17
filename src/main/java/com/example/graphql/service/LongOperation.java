package com.example.graphql.service;

import java.util.Optional;

public class LongOperation {
    public static void simulate(Optional<Integer> milliseconds) {
        try {
            Thread.sleep(milliseconds.orElse(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
